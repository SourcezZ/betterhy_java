package com.betterhy.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * ID生成器
 *
 * @author Source
 * @date 2020-08-12 15:42
 **/

//暂时注释，因为未使用，用的那天再说
//@Component
public class IdGenerator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Value("${app.idGenerator.workerId}")
    private long workerId;
    @Value("${app.idGenerator.datacenterId}")
    private long datacenterId;
    private long sequence = 0L;

    private long twepoch = 1288834974657L;

    private long workerIdBits = 8L;
    private long datacenterIdBits = 2L;
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;

    /*
     * workerId是机器ID，datacenterId是数据中心ID或机房ID。
     * 这都是为分布式而设置的，workerId每台机器肯定不一样，最大值由maxWorkerId限制。
     */
    public IdGenerator() {
        // 可以在命令行中添加参数覆盖application.yaml中的配置
        // 比如--app.idGenerator.workerId=1 --app.idGenerator.datacenterId=0

    }

    @PostConstruct
    public void init() {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        System.out.println(String.format(
                "worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
                timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId));
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            long delay = lastTimestamp - timestamp;
            System.out.println("等待时间追平" + delay);
            try {
                Thread.sleep(delay + 1);
            } catch (InterruptedException e) {
                logger.error(OaUtils.getStackTraceInfo(e));
            }
            timestamp = timeGen();
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return (((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift) | sequence);
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

}

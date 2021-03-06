package com.betterhy;

import com.betterhy.common.utils.DateUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Source
 */
@ImportResource("classpath:/applicationContext.xml")
@MapperScan({"com.betterhy.common.db.dao.generate","com.betterhy.common.db.dao.extend"})
@SpringBootApplication
public class BetterhyApplication {
    static Logger logger = LoggerFactory.getLogger(BetterhyApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(BetterhyApplication.class, args);
        logger.info("Started OaApplication at " + DateUtils.getDateTime());
    }
}

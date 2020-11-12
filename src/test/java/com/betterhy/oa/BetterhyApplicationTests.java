package com.betterhy;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.HashMap;
import java.util.Map;


@TestPropertySource("classpath:/application-test.properties")
@SpringBootTest
class BetterhyApplicationTests {

    private final static Logger log = LoggerFactory.getLogger(BetterhyApplicationTests.class);

    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("beginDate", "2020-10-01");
        map.put("endDate", "2020-10-31");
        map.put("username", "何源");
        map.put("userId", 26);
    }

}

package com.study.clickhouse;

import com.study.clickhouse.entity.TestTable;
import com.study.clickhouse.service.ITestTableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Random;

@SpringBootTest
public class insertDebugData {


    @Autowired
    ITestTableService iTestTableService;

    @Test
    public void test() {

        for (int i = 0; i < 1000000000 ; i++){
            TestTable user = new TestTable();
            user.setId(i);
            user.setRegTime(LocalDate.now());
            user.setVersion("test");
            Random r = new Random();
            float f = r.nextInt(100) + r.nextFloat();
            user.setAppId(Float.toString(f));
            iTestTableService.save(user);
        }
    }
}

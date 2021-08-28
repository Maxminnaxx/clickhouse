package com.study.clickhouse.controller;


import com.study.clickhouse.entity.TestTable;
import com.study.clickhouse.service.ITestTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Random;

/**
 * <p>
 * test_table 前端控制器
 * </p>
 *
 * @author generator
 * @since 2021-08-28
 */
@Controller
@RequestMapping("/test-table")
public class TestTableController {
    @Resource
    ITestTableService iTestTableService;

    @GetMapping
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

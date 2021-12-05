package com.course.testng.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//所有测试套件的配置类
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite运行了");
    }

     @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite运行了");
    }
}

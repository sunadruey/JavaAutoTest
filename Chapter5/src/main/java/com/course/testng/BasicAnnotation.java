package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public  void  testCase1(){
        System.out.printf("Thread Id : %s%n ",Thread.currentThread().getId() );
        System.out.println("Test这是测试用例1");

    }
    @Test
    public  void testCase2(){
        System.out.printf("Thread Id : %s%n ",Thread.currentThread().getId() );
        System.out.println("Test这是测试用例2");
    }

    @BeforeMethod
    public  void beforeMethod(){
        System.out.printf("Thread Id : %s%n ",Thread.currentThread().getId() );
        System.out.println("beforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod这是在测试方法之后运行的");
    }


// 使用场景：类正式运行前是不是需要注册写对象，静态东西。赋值什么的，静态方法 变量赋值，这样其他方法就可以用了
    @BeforeClass
    public void  beforeClass(){
        System.out.println("BeforeClass这是在类运行之前运行的方法");
    }

    @AfterClass
    public  void  afterClass(){
        System.out.println("AfterClass这是在类运行之后运行的方法");
    }

//  suit测试套件把class（类）包裹起来了 ，类属于测试套件之下
    @BeforeSuite
    public  void  beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public  void  afterSuite(){
        System.out.println("AfterSuite测试套件");
    }

}

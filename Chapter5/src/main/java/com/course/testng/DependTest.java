package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {


    @Test
    public void  test1(){
        System.out.println("test1 run");
        throw  new RuntimeException();

    }


    /**
     * test2依赖test1,
     * test1不成功 test2不运行
     * 后面为依赖的方法名字
     */

    @Test(dependsOnMethods = {"test1"})
    public void  test2(){
        System.out.println("test2 run");
    }
}

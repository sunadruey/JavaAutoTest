package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/***
 * 配置项 parameter.xml传参
 *
 */
public class ParamterTest {


    @Test
    @Parameters({"name","age"})
    public  void paramterTest1(String name ,int age){
        System.out.println("name = "+ name + " ;  age = " + age);
    }
}

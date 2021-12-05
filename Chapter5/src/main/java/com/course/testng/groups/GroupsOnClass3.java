package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void  teacher1(){

        System.out.println("GroupsOnClass-2中的 teacher1111运行");
    }

    public void   teacher2(){

        System.out.println("GroupsOnClass-2中的 teacher222运行");
    }

}

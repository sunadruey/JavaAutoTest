package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
    /**
     *   invocationCount =默认是1
     *   线程池里面就一个1
     *   多线程注意跨线程的关联需要加上锁
     *   提高执行效率，并行执行测试用例
     */

    @Test(invocationCount = 10,threadPoolSize = 3)
    public  void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n ",Thread.currentThread().getId() );
    }
}

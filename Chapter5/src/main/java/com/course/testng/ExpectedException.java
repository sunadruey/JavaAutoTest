package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /***
     * 我们的期望结果为一个异常时
     * 比如传入了某些不合法的参数，程序抛出异常
     * 即我们期待的就是这个异常
     *
     */

    //这是一个测试结果会失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public  void  runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }



    //这是一个成功的的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public  void  runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw  new RuntimeException();
    }

}

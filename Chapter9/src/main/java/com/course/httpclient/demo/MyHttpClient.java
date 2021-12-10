//package com.course.httpclient.demo;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class MyHttpClient {
//    @Test
//    public  void test1() throws IOException {
//        //用来存放我们的结果
//        String result;
//
//        HttpClient client = new HttpClient();
//        HttpGet get = new HttpGet("https://www.baidu.com/");
//        //用来执行get方法的
//        HttpClient client = new DefaultHttpClient();
//        client.execute(get);
//        HttpResponse response =client.execute(get);
//
//
//
//
////        String url = String.format("%s%s",this.userCenterPhoneDecryUrl, CommonConstant.USER_SYNC_APP_PATH_PHONE_DECRY);
////        Map<String, String> paramMap = this.getParamMap(accountType, userIds);
////        log.warn("_____queryPhoneByUserIds, url:{}, param: {}", url, paramMap);
//
//
//
//
//
//
////        String response = HttpClientUtil.doPost("https://www.baidu.com/");
//
////        result= EntityUtils.toString(response.getEntity(),"utf-8");
////        System.out.println(response);
//
//
//
//    }
//}

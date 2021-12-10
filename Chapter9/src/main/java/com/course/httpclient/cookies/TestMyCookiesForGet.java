package com.course.httpclient.cookies;


import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestMyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private Cookie[] cookies;


    @BeforeTest
    public  void  beforeTest(){
        bundle =ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();
        // Create a method instance.
        GetMethod method = new GetMethod(testUrl);

        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        client.executeMethod(method);

        this.cookies = client.getState().getCookies();
        if (cookies.length == 0) {
            //如果获取cookies为空
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies.length);
                String value= cookies[i].getValue();
                String name= cookies[i].getName();
                System.out.println("Cookie-name  : " + name);
                System.out.println("Cookie-value : " + value);

                String a = cookies[i].toString();
                //获取cookies里面所有信息
                System.out.println();
                System.out.println(a);
            }


//       System.out.println(Arrays.toString(client.getState().getCookies()));

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.out.println(new String(responseBody));


        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri = bundle.getString("getWithCookies.uri");
        String testUrl = this.url + uri;
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();
        System.out.println("url  +  "+ testUrl);

        // Create a method instance.
        GetMethod method = new GetMethod(testUrl);
        client.executeMethod(method);
        //设置cookis



        //获取状态码
        int statusCode=method.getStatusLine().getStatusCode();
        System.out.println("statusCode  +  "+ statusCode);
        if(statusCode ==200){

            byte[] responseBody = method.getResponseBody();
            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.out.println(new String(responseBody));

        }




    }
}


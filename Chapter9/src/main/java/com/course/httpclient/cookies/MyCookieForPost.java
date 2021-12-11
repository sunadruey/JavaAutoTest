package com.course.httpclient.cookies;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookieForPost {

    private String url;
    private ResourceBundle bundle;
    private Cookie[] cookies;


    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
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
                String value = cookies[i].getValue();
                String name = cookies[i].getName();
                System.out.println("Cookie-name  : " + name);
                System.out.println("Cookie-value : " + value);

                String a = cookies[i].toString();
                //获取cookies里面所有信息
                System.out.println();
                System.out.println(a);
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.out.println(new String(responseBody));

        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethods() throws IOException {
        String uri = bundle.getString("postWithCookies.uri");
        String testUrl = this.url + uri;
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();
        System.out.println("url  +  " + testUrl);
        // Create a method instance.
        PostMethod method = new PostMethod(testUrl);

        //添加参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","huhansan");
        jsonObject.put("age","18");
        String  toJson = jsonObject.toString();
        RequestEntity se = new StringRequestEntity(toJson ,"application/json" ,"UTF-8");
        method.setRequestEntity(se);

        //添加请求头信息
        method.setRequestHeader("Content-Type","application/json");
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        //设置超时时间
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);


        //设置cookis
        System.out.println("==========Cookies============");
        int j = 0;
        for (Cookie c: this.cookies) {
            System.out.println(++j + ":   " + c);
        }
        client.getState().addCookies(this.cookies);
        System.out.println("url  +  "+ testUrl);
        // Create a method instance.
        client.executeMethod(method);

        //获取状态码
        int statusCode=method.getStatusLine().getStatusCode();
        System.out.println("statusCode  +  "+ statusCode);
        if(statusCode ==200) {

        //返回结果
            String response =method.getResponseBodyAsString();
            JSONObject result = new JSONObject(new String(response));
            System.out.println("返回的结果的json形式： "+ result);
            String success = (String)result.get("huhansan");
            Assert.assertEquals("success",success);

        }

        }
}





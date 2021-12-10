package com.course.httpclient.cookies;

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


    @BeforeTest
    public  void  beforeTest(){
        bundle =ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("getCookies.uri");
        String  testUrl=this.url+uri;
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();
        // Create a method instance.
        GetMethod method = new GetMethod(testUrl);


        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        int statusCode = client.executeMethod(method);

            // Read the response body.
         byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
        System.out.println(new String(responseBody));

        //获取cookies信息
//        method.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
//        method.setRequestHeader("Cookie", "special-cookie=value");



//        CookieStore store = client.getCookiesStore();
//        List<Cookie> cookieList = store.getCookies();
//        for(Cookie cookie: cookieList){
//            String name=cookie.getName();
//            String value =cookie.getValue();
//            System.out.println("Cookie name =" +name +";cookie value = "+ value);
        }

    }


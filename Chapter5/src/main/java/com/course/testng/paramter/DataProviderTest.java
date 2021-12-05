package com.course.testng.paramter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

/**
 * 第二个通过方法名传递参数 DataProvider
 */
public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {

        System.out.println("name = " + name + " ;  age = " + age);

    }

    /***
     * 下面方法返回的数据给上面的方法使用，即数据的来源
     * name age 接住
     * @return
     */
    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{
                {"张三", 10},
                {"李四", 20},
                {"王五", 30}
        };
        return o;

    }





    /**
     *
     */
    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {

        System.out.println("test1111 " + "name = " + name + " ;  age = " + age);

    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {

        System.out.println("test222  " + "name = " + name + " ;  age = " + age);

    }

    //必须写Method method 因为他和上面的test1 和test2方法名字是关联的
    //不同的方法传递不同的参数
    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"张含运", 10},
                    {"李彻", 20},
                    {"薛之谦", 30}
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"赵丽颖", 40},
                    {"毛不易", 10},
                    {"杨幂", 30}

            };
        }
            return result;
        }
    }

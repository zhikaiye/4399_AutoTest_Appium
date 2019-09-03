package com.m4399.data;

import org.testng.annotations.DataProvider;

public class DataSource {

    @DataProvider
    public static Object[][] loginData(){
        return new Object[][]{
                {"2017011111","124567","密码错误"},
                {"2017011117","123456","登陆成功"}
        };
    }
}

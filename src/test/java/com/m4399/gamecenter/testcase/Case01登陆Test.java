package com.m4399.gamecenter.testcase;

import com.m4399.gamecenter.driver.Driver;
import com.m4399.gamecenter.pages.Page找游戏;
import com.m4399.gamecenter.utils.CsvRead;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Iterator;

public class Case01登陆Test {
    @DataProvider(name = "logindata")
    public Object[][] logindata(){
        Object[][] objects = new Object[][]{
                {"2017011111","124567","密码错误"},
                {"2017011117","123456","登陆成功"}
        };
        return objects;
    }

    @DataProvider(name = "datalogin")
    public Iterator<Object[]> datelogin(){
        CsvRead csvRead = new CsvRead();
        return csvRead.readDataFromCSV("/Users/zhikaiye/IdeaProjects/4399autotest_appium/src/main/resources/datalogin.csv");
    }

    @BeforeClass
    public void setUp(){

    }

    @Test(dataProvider = "datalogin")
    public void 登陆(String username,String password,String expect) throws MalformedURLException {
        Page找游戏 page找游戏 = new Page找游戏().进入找游戏首页();
        Assert.assertEquals(page找游戏.点击我().点击登陆().登陆(username, password),expect);
    }

    @AfterClass
    public void tearDown(){
        Driver.getCurrentDriver().quit();
    }
}

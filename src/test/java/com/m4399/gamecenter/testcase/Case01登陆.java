package com.m4399.gamecenter.testcase;

import com.m4399.gamecenter.driver.Driver;
import com.m4399.gamecenter.pages.Page找游戏;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Case01登陆 {

    @BeforeTest
    public void case01(){
        System.out.println("This is beforetest");
    }

    @AfterTest
    public void tearDown(){
        Driver.getCurrentDriver().quit();
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("This is beforeclass");
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("this is beforemethod");
    }
    @DataProvider(name = "haha")
    public Object[][] logindata(){
        Object[][] objects = new Object[][]{
                {"2017011111","124567"},
                {"2017011117","123456"}
        };
        return objects;
    }

    @Test(dataProvider = "haha")
    public void 登陆(String username,String password) throws MalformedURLException {
        Page找游戏 page找游戏 = new Page找游戏().进入找游戏首页();
        System.out.println(page找游戏.点击我().点击登陆().登陆(username, password));
    }

    @Test
    public void suibian(){
        System.out.println("zhe ge shi suib");
    }
//
//    @AfterMethod
//    public void aftermethod(){
//        System.out.println("this is aftermethod");
//    }
//
//    @BeforeClass
//    public void afterclass(){
//        System.out.println("This is afterclass");
//    }
//
//    @AfterTest
//    public  void aftertest(){
//        System.out.println("this is aftertest");
//    }
}

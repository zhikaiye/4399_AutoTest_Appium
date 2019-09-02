package com.m4399.gamecenter.testcase;

import com.m4399.gamecenter.driver.Driver;
import com.m4399.gamecenter.pages.Page找游戏;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Case02滑动Test {

    @Test
    public void huadong() throws MalformedURLException {

        Page找游戏 page找游戏 = new Page找游戏().进入找游戏首页();
        page找游戏.滑动找到首页游戏("龙族幻想");

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        Driver.getCurrentDriver().quit();
    }
}

package com.m4399.gamecenter.pages;

import com.m4399.gamecenter.driver.Driver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class Page找游戏 extends BasePage {
    By me = byXpathAndId("//*[@resource-id='com.m4399.gamecenter:id/ctl_indicator']/android.widget.LinearLayout/android.widget.RelativeLayout[5]");

    public Page找游戏 进入找游戏首页() throws MalformedURLException {

        Driver.startDriver();

        return new Page找游戏();
    }

    public Page我页 点击我() {

        find(me).click();

        return new Page我页();
    }
}

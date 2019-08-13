package com.m4399.gamecenter.pages;

import org.openqa.selenium.By;

public class Page我页 extends BasePage {

    By btn_login = byXpathAndId("btn_login");

    public Page登陆注册 点击登陆() {

        find(btn_login).click();

        return new Page登陆注册();

    }


}

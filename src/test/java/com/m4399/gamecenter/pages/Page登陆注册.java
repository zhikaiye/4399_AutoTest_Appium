package com.m4399.gamecenter.pages;

import org.openqa.selenium.By;

public class Page登陆注册 extends BasePage{
    By et_username = byXpathAndId("et_username");
    By et_password = byXpathAndId("et_password");
    By login_button = byXpathAndId("login_button");

    public Page我页 成功登陆(String username,String password){

        find(et_username).sendKeys(username);
        find(et_password).sendKeys(password);
        find(login_button).click();

        return new Page我页();
    }


}

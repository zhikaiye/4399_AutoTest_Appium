package com.m4399.gamecenter.pages;

import com.m4399.gamecenter.driver.Driver;
import org.openqa.selenium.By;

public class Page登陆注册 extends BasePage {
    By et_username = byXpathAndId("et_username");
    By et_password = byXpathAndId("et_password");
    By login_button = byXpathAndId("login_button");

    /**
     * 1、登陆成功返回toast："登陆成功"；
     * 2、登陆失败则根据具体toast提示进行返回；
     *
     * @return
     */
    public String 登陆(String username, String password) {
        find(et_username).sendKeys(username);
        find(et_password).sendKeys(password);
        find(login_button).click();
        String toast = getToast();
        try {
            elementWait(Driver.getCurrentDriver(), 10, By.id("com.m4399.gamecenter:id/tv_user_name")).isDisplayed();
            return "登陆成功";
        } catch (Exception e) {
            return toast;
        }
    }
}

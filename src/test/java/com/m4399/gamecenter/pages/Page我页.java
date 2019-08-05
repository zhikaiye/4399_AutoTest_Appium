package com.m4399.gamecenter.pages;

import com.m4399.gamecenter.driver.Driver;
import org.openqa.selenium.By;

public class Page我页 {

    public Page登陆注册 点击登陆(){

        Driver.getCurrentDriver().findElement(By.id("com.m4399.gamecenter:id/btn_login")).click();

        return new Page登陆注册();

    }


}

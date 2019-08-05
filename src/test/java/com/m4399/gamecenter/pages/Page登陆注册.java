package com.m4399.gamecenter.pages;

import com.m4399.gamecenter.driver.Driver;
import org.openqa.selenium.By;

public class Page登陆注册 {

    public Page我页 成功登陆(){

        Driver.getCurrentDriver().findElement(By.id("com.m4399.gamecenter:id/et_username")).sendKeys("18202823820");
        Driver.getCurrentDriver().findElement(By.id("com.m4399.gamecenter:id/et_password")).sendKeys("123456");
        Driver.getCurrentDriver().findElement(By.id("com.m4399.gamecenter:id/login_button")).click();

        return new Page我页();
    }


}

package com.m4399.gamecenter.pages;

import com.m4399.gamecenter.driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    static WebElement find(By locator){
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getCurrentDriver(),10);
        int i=0;
        boolean a,b;
        Point[] points = new Point[10];
        do {
            points[i] = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator)).getLocation();
            System.out.println(points[i]);
            a = i>=2&&(points[i-2].equals(points[i-1])&&points[i-1].equals(points[i]));
            i++;
            b = (i>points.length-1|a);
        }while (!b);

        try {
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            e.printStackTrace();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

    static By byXpathAndId(String locater){
        if (locater.matches("/.*")){
            return By.xpath(locater);
        }else {
            return By.id(locater);
        }
    }
    static By byText(String name){
        return By.xpath("//*[@text='"+name+"']");
    }

    static void swipe(AndroidDriver driver, Point x, Point y){

        TouchAction touchAction = new TouchAction(driver);
        System.out.println("aaa");

    }
}

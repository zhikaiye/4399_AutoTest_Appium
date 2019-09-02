package com.m4399.gamecenter.pages;

import com.m4399.gamecenter.driver.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    static By[] byList ;
    BasePage() {
        byList = new By[]{
                byXpathOrID("//*[@resource-id='com.m4399.gamecenter:id/btn_dialog_horizontal_left']"),
                byXpathOrID("//*[@resource-id='android:id/button1' and @text='允许']"),
                byXpathOrID("//*[@resource-id='com.m4399.gamecenter:id/tv_skip']")
        };
    }

    /**
     * 自定义find方法:循环查找元素（最多10次），若元素坐标连续3次不发生改变，则返回该element
     *
     * @param locator
     * @return
     */
    static AndroidElement find(By locator) {

        int i = 0;
        boolean a, b;
        Point[] points = new Point[10];
        do {
            try {
                points[i] = elementWait(Driver.getCurrentDriver(), 10, locator).getLocation();
            } catch (org.openqa.selenium.TimeoutException e) {
                elementWatch(byList);
                points[i] = elementWait(Driver.getCurrentDriver(), 10, locator).getLocation();
            }
            System.out.println(points[i]);
            a = i >= 2 && (points[i - 2].equals(points[i - 1]) && points[i - 1].equals(points[i]));
            i++;
            b = (i > points.length - 1 | a);
        } while (!b);

        return Driver.getCurrentDriver().findElement(locator);
    }



    static By byXpathOrID(String locater) {
        if (locater.matches("/.*")) {
            return By.xpath(locater);
        } else {
            return By.id(locater);
        }
    }

    static By byText(String name) {
        return By.xpath("//*[@text='" + name + "']");
    }

    /**
     * 滚动到制定的text
     * @param driver
     * @param className
     * @param content
     */
    static void scrollIntoViewByText(AndroidDriver driver, String className, String content) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\""+className+"\")).scrollIntoView(new UiSelector().text(\""+content+"\"))"
        );

    }

    /**
     * 滚动到制定的ResourceID
     * @param driver
     * @param className
     * @param content
     */
    static void scrollIntoViewByResourceID(AndroidDriver driver,String className,String content){
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\""+className+"\")).scrollIntoView(new UiSelector().resourceId(\""+content+"\"))"
        );
    }

    /**
     * 滚动到制定的Description
     * @param driver
     * @param className
     * @param content
     */
    static void scrollIntoViewByDescription(AndroidDriver driver,String className,String content){
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\""+className+"\")).scrollIntoView(new UiSelector().description(\""+content+"\"))"
        );
    }


    /**
     * 判断页面是否存在element。存在返回true，否则为false。
     *
     * @param by
     * @return
     */
    static boolean elementIsExist(By by) {
        try {
            Driver.getCurrentDriver().findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 元素监听，并且进行点击，遍历数组
     *
     * @param list
     */
    static void elementWatch(By[] list) {
        for (By by : list) {
            System.out.println(elementIsExist(by));
            if (elementIsExist(by)) {
                Driver.getCurrentDriver().findElement(by).click();
                break;
            }
        }
    }

    /**
     * 等待查找element
     * @param driver
     * @param timeout
     * @param locator
     * @return
     */
    static WebElement elementWait(WebDriver driver, int timeout, By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        try {
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (org.openqa.selenium.TimeoutException e){
            elementWatch(byList);
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

    }

    /**
     * 获取页面toast：10秒内等待找到toast，未找到返回"未找到toast或者发生其它异常"
     *
     * @return
     */

    static String getToast() {

       try {
           return elementWait(Driver.getCurrentDriver(),10,By.xpath("//*[@class='android.widget.Toast']")).getText();
       }catch (Exception e){
           return "未找到toast或者发生其它异常";
       }
    }


}

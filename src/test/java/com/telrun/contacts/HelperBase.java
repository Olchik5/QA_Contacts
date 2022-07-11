package com.telrun.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver =  driver;
    }

    public boolean isElementPresent(By locator){
        return  driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent2(By by){
    try {
        driver.findElement(by);
        return true;
    } catch (NoSuchElementException exception) {
        return false;
    }
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickWithAction(By save){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(save);

        actions.moveToElement(element).perform();
        element.click();

    }
}

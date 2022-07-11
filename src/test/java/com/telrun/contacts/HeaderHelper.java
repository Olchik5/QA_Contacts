package com.telrun.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class  HeaderHelper extends HelperBase{
    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginLinkPresent() {
       return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
   }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }
}

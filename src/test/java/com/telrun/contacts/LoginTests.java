package com.telrun.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getUser().click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void LoginUserPositiveTest() {
        //click on Login link; //fill login form; //click on the button Login
        app.getUser().login();
        //assert the button SignOut
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

}

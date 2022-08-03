package com.telrun.contacts.tests;

import com.telrun.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

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

    @Test
    public void loginUserNegativeTest(){
        app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(new User().setEmail("kuku+1@mail.com"));
        Assert.assertTrue(app.getUser().isAlertPresent());
        Assert.assertTrue(app.getUser().isErrorPresent());
    }

}

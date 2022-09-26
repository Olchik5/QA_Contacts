package com.telrun.contacts.tests;

import com.telrun.contacts.models.User;
import com.telrun.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getUser().click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }
    
    @Test(enabled = false)
    public void registrationPositiveTest(){
        //click on the link LOGIN
        app.getUser().registration();
        //assert the button Sign out displayed
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }


    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void negativeRegistrationTestWithInvalidEmailFromDataProvider(String email, String password){
        //click on the link LOGIN
        app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(new User().setEmail(email).setPassword(password));
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));

        //assert the Alert displayed
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}

package com.telrun.contacts.tests;

import com.telrun.contacts.models.Contact;
import com.telrun.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getUser().click(By.xpath("//button[contains(.,'Sign Out')]"));
        } else {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Phil"));
    }

    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class, enabled = false)
    public void addContactPositiveTestFromDataProvider(String name, String sName, String phone,
                                                       String email, String address, String des) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(new Contact().setName(name)
                .setSureName(sName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(des));
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));

    }

    @Test(dataProvider = "addNewContactFromCSV",dataProviderClass = DataProviders.class, enabled = false)
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));

    }
    @AfterMethod
    public void postCondition(){

        app.getContact().removeContact();
    }

}
package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class CreateContact {
    static Map<String, String> data;

    public CreateContact() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^=oro_contact_form_namePrefix-uid]")
    public WebElement namePrefix;

    @FindBy(css = "[id^=oro_contact_form_firstName-uid]")
    public WebElement firstName;

    @FindBy(css = "[id^=oro_contact_form_middleName-uid]")
    public WebElement middleName;

    @FindBy(css = "[id^=oro_contact_form_lastName-uid]")
    public WebElement lastName;

    @FindBy(css = "[id^=oro_contact_form_nameSuffix-uid]")
    public WebElement nameSuffix;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement description;

    @FindBy(css = "a[data-action=cancel]")
    public WebElement cancel;

    @FindBy(xpath = "(//button[contains(text(), 'Save and Close')])[1]")
    public WebElement saveAndClose;

    @FindBy(css = "iframe[id^='oro_contact_form_description-uid']")
    public WebElement iFrame;

    public void fillWithRandomData() {
        CreateContact boxes = new CreateContact();
        Faker generate = new Faker();
        data = new HashMap<>();
        data.put("firstName", generate.name().firstName());
        data.put("lastName", generate.name().lastName());
        data.put("description", generate.book().title());
        BrowserUtils.clickWithTimeOut(boxes.firstName, 5);
        boxes.firstName.sendKeys(data.get("firstName"));
        boxes.lastName.sendKeys(data.get("lastName"));
        Driver.get().switchTo().frame(iFrame);
        boxes.description.sendKeys(data.get("description"));
        Driver.get().switchTo().defaultContent();
    }

    public void verifyThatContactWasCreated() {
        Contact contact = new Contact();
        Assert.assertEquals(data.get("firstName") + " " + data.get("lastName"), contact.contactName.getText());
        Assert.assertEquals(data.get("description"), contact.description.getText());
    }


}

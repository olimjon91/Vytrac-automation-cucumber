package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
    public Contact(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = ".user-name")
    public WebElement contactName;

    @FindBy(css = "a[title='Edit Contact']")
    public WebElement edit;

    @FindBy(css = "a[title='Delete Contact']")
    public WebElement delete;

    @FindBy(css = "a[title='Add an event to this record']")
    public WebElement addEvent;

    @FindBy(xpath = "//label[.='Description']/..//div/div")
    public WebElement description;
}

package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalendarEvent {
    public CreateCalendarEvent(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//input[starts-with(@id,'oro_calendar')])[2]")
    public WebElement title;
}

package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEvents {
    public CalendarEvents(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//div[@class='btn-group']/a")
    public WebElement createCalendarEvent;

    public WebElement event(String name){
        return Driver.get().findElement(By.xpath("//tr/td[.='"+name+"']"));
    }

    public void createCalendarEvent(String name){
        BrowserUtils.clickWithTimeOut(createCalendarEvent, 10);
    }

}

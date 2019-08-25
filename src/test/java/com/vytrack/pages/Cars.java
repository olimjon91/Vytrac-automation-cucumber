package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cars {
    public Cars(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement firstRow;

}

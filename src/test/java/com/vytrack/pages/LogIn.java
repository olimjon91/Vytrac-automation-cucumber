package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import cucumber.api.java.tr.Fakat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
    public LogIn() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#prependedInput")
    public WebElement usernameBox;

    @FindBy(css = "#prependedInput2")
    public WebElement passwordBox;

    @FindBy(css = "#_submit")
    public WebElement submitButton;

    @FindBy(css = ".alert.alert-error>div")
    public WebElement errorMasage;

    public void logInAs(String user) {
        String username = ConfigurationReader.get(user);
        String password = ConfigurationReader.get("password");
        if (username == null) {
            username = new Faker().name().username();
            password = new Faker().internet().password();
        }
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        submitButton.click();

    }

}



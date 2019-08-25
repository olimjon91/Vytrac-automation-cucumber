package com.vytrack.step_defenitions;

import com.vytrack.pages.Cars;
import com.vytrack.pages.NavigationMenu;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DriverAccessVehiclePageStepDefs {
    @Given("I navigate to {string}")
    public void i_navigate_to(String module_page) {
        new NavigationMenu().navigateTo(module_page);
    }

    @And("Verify a total of records displayed")
    public void verifyATotalOfRecordsDisplayed() {
        Assert.assertTrue(new NavigationMenu().totalOfRecords.getText().contains("Total"));
    }

    @Then("Click first car from list of cars")
    public void click_car_from_list_of_cars() {
        BrowserUtils.clickWithTimeOut(new Cars().firstRow, 10);

    }

    @Then("Verify that the {string} displayed")
    public void verify_that_the_displayed(String text) {
        Driver.get().findElement(By.xpath("//span[.='" + text + "']"));
        Assert.assertTrue(true);
    }

    @Then("Create {string} calendar event")
    public void create_calendar_event(String string) {
        BrowserUtils.waitFor(5);
        /**
         * TO DO
         */

    }
}

package com.vytrack.step_defenitions;

import com.vytrack.pages.LogIn;
import com.vytrack.pages.NavigationMenu;
import com.vytrack.utilities.BrowserUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;


public class LoginStepDefs {

    @Given("I log in as a {string}")
    public void i_log_in_as_a(String user) {
        new LogIn().logInAs(user);
    }

    @Then("Verify that page name is {string}")
    public void verifyThatPageNameIs(String name) {
        int times = 0;
        while (!new NavigationMenu().pageName.getText().equals(name) && times < 10) {
            BrowserUtils.waitFor(1);
            times++;
        }
        Assert.assertEquals(name, new NavigationMenu().pageName.getText());
    }

    @Given("Try to login with invalid credentials")
    public void try_To_Log_in_With_Invalid_Credentials() {
        new LogIn().logInAs("anyone");
    }

    @Then("Verifying invalid username or password displayed")
    public void verifying_invalid_username_or_password_displayed() {
        Assert.assertEquals(new LogIn().errorMasage.getText(), "Invalid user name or password.");
    }
}

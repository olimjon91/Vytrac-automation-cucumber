package com.vytrack.step_defenitions;

import com.vytrack.pages.Contacts;
import com.vytrack.pages.CreateContact;
import com.vytrack.utilities.BrowserUtils;
import cucumber.api.java.en.Then;

public class ContactCreatingStepDefs {
    @Then("I click on create contact button")
    public void i_click_on_create_contact_button() {
        BrowserUtils.clickWithTimeOut(new Contacts().createContact, 5);
    }

    @Then("Fill out the contact info with random data")
    public void fill_out_the_contact_info_with_random_data() {
        CreateContact createContact = new CreateContact();
        createContact.fillWithRandomData();
    }
    @Then("Click on save and close button")
    public void click_on_save_and_close_button() {
        new CreateContact().saveAndClose.click();
    }

    @Then("Verify that contact was successfully created")
    public void verify_that_contact_was_successfully_created() {
        new CreateContact().verifyThatContactWasCreated();
    }

}

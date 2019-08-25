@createContact
Feature: All users should ne able create contact

  @regression
  Scenario Outline: Verifying that each user can create contact
    Given I log in as a "<user>"
    Given I navigate to "Customers, Contacts"
    Given Verify that page name is "Contacts"
    Then I click on create contact button
    Then Verify that page name is "Create Contact"
    And Fill out the contact info with random data
    And Click on save and close button
    Then Verify that contact was successfully created

    Examples:
      | user         |
      | driver       |
      | salesmanager |
      | storemanager |

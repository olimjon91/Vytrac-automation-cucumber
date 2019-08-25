Feature: Log in
  As a user i should be able to
  log in using valid user credentials
  As a user i should not be able to
  log in with invalid user credentials

  @login @smoke @regression
  Scenario Outline: Log in with different valid credentials
    Given I log in as a "<user>"
    Then Verify that page name is "<page_name>"

    Examples:
      | user         | page_name       | tt
      | driver       | Quick Launchpad | sd
      | salesmanager | Dashboard       | dfd
      | storemanager | Dashboard       | df

  Scenario: Log in with invalid credentials
    Given Try to login with invalid credentials
    Then Verifying invalid username or password displayed



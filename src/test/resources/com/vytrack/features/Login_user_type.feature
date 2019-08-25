Feature: Login different types of users

  @test
  Scenario Outline: Login as different users
    Given I log in as a "<user>"


    Examples:
      | user         |
      | driver       |
      | storemanager |
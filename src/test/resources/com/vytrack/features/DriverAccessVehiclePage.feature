@vehicle
Feature: As a truck driver I should be able to access vehicle under Fleet module

  Scenario: Verify that truck driver sees all Vehicle information on Vehicle page
    Given I log in as a "driver"
    Given I navigate to "Fleet, Vehicles"
    Then Verify that page name is "Cars"
    And Verify a total of records displayed


  Scenario: Verify that when user click on any car on the grid,
            system should display general information about the car
    Given I log in as a "driver"
    Given I navigate to "Fleet, Vehicles"
    Then Click first car from list of cars
    Then Verify that the "General Information" displayed

    #@test TO DO
    Scenario: Verify that truck driver can add Event,
            and it should display under Activity tab and General information page as well .
      Given I log in as a "driver"
      Given I navigate to "Activities, Calendar Events"
      Then Create "Party" calendar event



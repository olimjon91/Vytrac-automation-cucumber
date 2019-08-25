Feature: As a user i should be able
  to open any page which visible
  ro that type of user

  @menu_option
  Scenario Outline: Navigating to different pages with different users
    Given I log in as a "<user>"
    Then I navigate to "<page>"
    Then Verify that page name is "<page_name>"
    Examples:
      | user   | page                         | page_name           |
      | driver | Fleet, Vehicles              | Cars                |
      | driver | Fleet, Vehicle Odometer      | Vehicles Odometers  |
      | driver | Fleet, Vehicle Costs         | Vehicle Costs       |
      | driver | Fleet, Vehicles Fuel Logs    | Vehicle Fuel Logs   |
      | driver | Fleet, Vehicle Services Logs | VehicleServicesLogs |

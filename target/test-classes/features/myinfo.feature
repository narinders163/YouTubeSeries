Feature: My info scenarios


  Background:
    Given the user is on the login page
    When user enters the "Admin" and "admin123"
    And user clicks on the Submit button
    And user clicks on MyInfo Button
    @006
    Scenario: My info elements count
      Then user should see exact number of  buttons
      @007
      Scenario: My info elements names
        Then user should see the exact names of the elements
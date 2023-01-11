@forgorpassword
Feature: forgot password scenarios

  @003
  Scenario: user clicks on forgot password
    Given the user is on the login page
    When the user clicks on the forgot password button
    Then the user should see the forgotpassword page
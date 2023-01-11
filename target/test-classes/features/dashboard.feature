Feature: dashboard page info and items
  Background:
    Given the user is on the login page
    When user enters the "Admin" and "admin123"
    And user clicks on the Submit button
  @008
    Scenario: verify items count
      Given dashboard page is visible
      Then verify the QuickLaunge items count
    @009
      Scenario: verify items text
        Given dashboard page is visible
        Then verify the QuickLanuge items names
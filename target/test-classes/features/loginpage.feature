#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@All
Feature: Login page

  Background:
    Given the user is on the login page
@Success
Scenario: Successfully Login
  When user enters the "Admin" and "Admin123"
  And user clicks on the Submit button
  Then user should be able to login

@Unsuccess
  Scenario: Login Unsuccessful
    When user enters the "Admin1" and "Admin123"
    And the user is on the login page
    Then user should not be able to login

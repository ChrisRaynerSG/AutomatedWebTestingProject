Feature: Registration
  If I enter correct name and email I should be sent to the signup page

@happy
  Scenario: Successful registration
    Given I am on the login page
    When I enter a valid name and email address
    And I click on the sign up button
    Then I am sent to the signup page

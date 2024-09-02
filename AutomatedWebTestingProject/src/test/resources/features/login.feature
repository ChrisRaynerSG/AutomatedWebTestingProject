@login
Feature: If I enter a valid username and password, I should be able to login

  @happy
    @login
  Scenario: Login with valid credentials
    Given I visit the login page
    And I have entered the username "abc@abc.abc"
    And I have entered the password "abc"
    When I click the login button
    Then I should land on the home page

  @sad
  @login
    Scenario: Login with invalid credentials
    Given I visit the login page
    And I have entered the username "abc@abc.abc"
    And I have entered the password "wrong_password"
    When I click the login button
    Then I should get an error message "Your email or password is incorrect!"

  @happy
    @login
    Scenario: Confirm that navigation logout button works
    Given I visit the login page
    And I have entered the username "abc@abc.abc"
    And I have entered the password "abc"
    When I click the login button
    And I click the logout button
    Then I will be logged out and land on the login page

  @sad
    @login
    Scenario: Confirm that delete account button doesn't exist when user is logged out
    Given I visit the login page
    And I have entered the username "abc@abc.abc"
    And I have entered the password "abc"
    When I click the login button
    And I click the logout button
    Then I will be logged out and land on the login page
    And I should not see the delete account button
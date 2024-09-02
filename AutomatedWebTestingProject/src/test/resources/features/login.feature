@login
Feature: If I enter a valid username and password, I should be able to login

  @happy
    @login, @registration
  Scenario: Login with valid credentials
    Given I am on the login page
    And I have entered the username "abc@abc.abc"
    And I have entered the password "abc"
    When I click the login button
    Then I should land on the home page

  @sad
  @login, @registration
    Scenario: Login with invalid credentials
    Given I am on the login page
    And I have entered the username "abc@abc.abc"
    And I have entered the password "wrong_password"
    When I click the login button
    Then I should land get an error message "Your email or password is incorrect!"
@registration
Feature: Registration
  If I enter correct name and email I should be sent to the signup page
  If I enter all mandatory fields I should be successfully registered
  I should then be able to delete my account

  @happy
  @registration
  Scenario Outline: Successful registration
    Given I am on the login page
    And I enter a valid name and email address
    And I click on the sign up button
    And I am sent to the signup page
    When I enter the following information
      | Field         | Value           |
      | Password      | <password>      |
      | First Name    | <first_name>    |
      | Last Name     | <last_name>     |
      | Address 1     | <address1>      |
      | Country       | <country>       |
      | State         | <state>         |
      | City          | <city>          |
      | Zipcode       | <zipcode>       |
      | Mobile Number | <mobile_number> |
    Then I am successfully registered
    And I continue to the home page
    And I can successfully delete my account

    Examples:
      | password | first_name | last_name | address1       | country       | state | city        | zipcode | mobile_number |
      | Pass1234 | John       | Doe       | 123 Elm Street | United States | CA    | Los Angeles | 90001   | 555-1234      |
      | 1234     | Adam       | Foe       | 123 Elm Street | United States | CA    | Los Angeles | 90001   | 555-1234      |
    #    | Jane Smith | jane.smith@example.com | Pass5678  | Pass5678        | 22      | July      | 1985     | false       | true          | Jane       | Smith     | Smith Ltd | 456 Oak Avenue     |                | Canada         | ON       | Toronto    | M5A 1A1 | 416-5678      |

  @sad
  @registration
  Scenario: register with pre-existing email address
    Given I am on the login page
    And I enter a valid name "abc"
    And I enter email address that is already registered "abc@abc.abc"
    When I click on the sign up button
    Then error "Email Address already exist!" should be displayed

  @sad
  @registration
  Scenario Outline: Not all mandatory fields provided during registration
    Given I am on the login page
    And I enter a valid name and email address
    And I click on the sign up button
    And I am sent to the signup page
    When I enter the following information
      | Field         | Value           |
      | Password      | <password>      |
      | First Name    | <first_name>    |
      | Last Name     | <last_name>     |
      | Address 1     | <address1>      |
      | Country       | <country>       |
      | State         | <state>         |
      | City          | <city>          |
      | Zipcode       | <zipcode>       |
      | Mobile Number | <mobile_number> |
    Then I am notified that all mandatory fields are required

    Examples:
      | password | first_name | last_name | address1       | country       | state | city        | zipcode | mobile_number |
      |  | John       | Doe       | 123 Elm Street | United States | CA    | Los Angeles | 90001   | 555-1234      |
      | 1234 | John       | Doe       | 123 Elm Street | United States |     | Los Angeles | 90001   | 555-1234      |
      | 1234 | John       | Doe       | 123 Elm Street | United States | CA    | Los Angeles |    | 555-1234      |
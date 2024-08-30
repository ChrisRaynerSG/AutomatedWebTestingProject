Feature: Testing the contact us form page

  @Happy
    @contactus
  Scenario: Do I land on the contact us page
    Given I am on the contact us page
    Then The the url should be that of the contact us page "https://automationexercise.com/contact_us"

    @Happy
      @contactus
    Scenario: Entering the correct details into the contact us page
      Given I am on the contact us page
      When I enter all the valid details
      And click the submit button
      Then I will be be promoted with a success message "Success! Your details have been submitted successfully."

  @Sad
    @contactus
  Scenario Outline: Testing different combinations of invalid inputs
    Given I am on the contact us page
    When I enter an invalid email "<emails>"
    And click the submit button
    Then I will be prompted with the message "<result>"
    Examples:
      | emails     | result                      |
      | empty      | Please fill out this field. |
      | test       | is missing an '@'.          |
      | test@      | is incomplete.              |
      | test@email | is incomplete.              |


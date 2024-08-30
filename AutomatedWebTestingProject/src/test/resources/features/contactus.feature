Feature: Testing the contact us form page

  @Happy
  Scenario: Do I land on the contact us page
    Given I am on the contact us page
    Then The the url should be that of the contact us page "https://automationexercise.com/contact_us"

    @Happy
    Scenario: Entering the correct details into the contact us page
      Given I am on the contact us page
      When I enter all the valid details
      And click the submit button
      Then I will be be promoted with a success message "Success! Your details have been submitted successfully."
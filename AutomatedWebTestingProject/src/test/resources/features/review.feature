Feature: Review
  As a registered user, I want to leave a review on the product so that I can inform other customer's buying decisions

  @Happy
  Scenario: Leaving a review with valid details
    Given I am on the product page
    And I enter a valid name and email
    And I enter a valid review
    When I click submit
    Then I see a message informing me the submission is successful

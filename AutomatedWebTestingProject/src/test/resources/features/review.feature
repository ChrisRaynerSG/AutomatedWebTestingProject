Feature: Review
  As a registered user, I want to leave a review on the product so that I can inform other customer's buying decisions

  @Happy
  Scenario: Leaving a review with valid details
    Given I am on the product page
    And I enter a valid name and email
    And I enter a valid review
    When I click submit
    Then I see a message informing me the submission is successful

  @Sad
  Scenario: Leaving a review with no personal details
    Given I am on the product page
    And I enter a valid review
    When I click submit
    Then I will not see a message informing me the submission is successful

  @Sad
  Scenario: Leaving a duplicated review should not submit the duplicate
    Given I am on the product page
    And I enter a valid name and email
    And I enter a valid review
    When I click submit
    Then I see a message informing me the submission is successful
    And I enter a valid name and email
    And I enter a valid review
    When I click submit
    Then I will not see a message informing me the submission is successful

  @Sad
  Scenario: Leaving a one character review should not submit the review
    Given I am on the product page
    And I enter a valid name and email
    And I enter a review containing "<input1>"
    When I click submit
    Then I will not see a message informing me the submission is successful
    Examples:
      | input1 |
      | 1      |
      | A      |
      | !      |
      | \      |
      |        |


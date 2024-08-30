@ReviewFeature
Feature: Review
  As a registered user, I want to leave a review on the product so that I can inform other customer's buying decisions

  @Happy
  @ReviewFeature
  Scenario: The review form should appear on the product page
    Given I am on the product page
    Then I should see the review submission form

  @Happy
  @ReviewFeature
  Scenario: Leaving a review with valid details
    Given I am on the product page
    And I enter a valid name and email
    And I enter a valid review
    When I click submit
    Then I see a message informing me the submission is successful

  @Sad
  @ReviewFeature
  Scenario: Leaving a review with no personal details
    Given I am on the product page
    And I enter a valid review
    When I click submit
    Then I will not see a message informing me the submission is successful

  @Sad
  @ReviewFeature
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
    @ReviewFeature
  Scenario Outline: Leaving a one character review should not submit the review
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
      |        |

  @Sad
    @ReviewFeature
  Scenario Outline: Leaving a review with profanity should not be submitted
    Given I am on the product page
    And I enter a valid name and email
    And I enter a review containing "<profanity>"
    When I click submit
    Then I will not see a message informing me the submission is successful
    Examples:
      | profanity |
      | darn      |
      | heck      |
      | crap      |
      | fudge     |
      | bummer    |

  @Sad
    @ReviewFeature

  Scenario Outline: Leaving a review with invalid email formats should not be submitted
    Given I am on the product page
    And I enter a valid name
    And I enter a review containing "Valid review"
    And I enter an invalid email "<invalidEmail>"
    When I click submit
    Then I will not see a message informing me the submission is successful
    Examples:
      | invalidEmail   |
      | invalidemail   |
      | @missingdomain |
      | missingdomain@ |
      | @              |

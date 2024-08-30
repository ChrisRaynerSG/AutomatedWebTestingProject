@search
Feature: As a user I want to be able to search for specific items, So that I can purchase something in particular

  @Happy
    @search
  Scenario: The search bar should appear on the all products page
    Given I am on the all products page
    Then I should see the product search bar
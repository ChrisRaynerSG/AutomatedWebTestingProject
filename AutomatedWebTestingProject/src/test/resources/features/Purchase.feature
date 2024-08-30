Feature: Purchase item from webpage

  Background:

  Scenario: add item to cart from homepage
    Given I am on the homepage
    When I click add to cart from products or home
    And the item is in stock
    Then I should see my cart updated

  Scenario: add item to cart from products page
    Given I am on the products page
    When I click add to cart from products or home
    And the item is in stock
    Then I should see my cart updated

  Scenario: add item to cart from items page
    Given I am on a specific items page
    When I click add to cart from item page
    And the item is in stock
    Then I should see my cart updated

  Scenario: go to checkout not logged in
    Given I am on the view_cart page
    And I have an item in my cart
    And I am not logged in
    When I click Proceed to checkout
    Then I should be instructed to login or register

  Scenario: go to checkout while logged in
    Given I am on the view_cart page
    And I have an item in my cart
    And I am logged in
    When I click Proceed to checkout
    Then I should be directed to the checkout page
    And my address details should be correct

  Scenario: Place an order
    Given I am on the checkout page
    When I click place order
    Then I should be directed to the payment page

  Scenario: invalid card details when making payment
    Given I am on the payment page
    And I have not input my card details
    When I click pay and confirm order
    Then I should be informed what is missing
    And remain on the payment page

  Scenario: make a payment
    Given I am on the payment page
    And I have input my card details
    When I click pay and confirm order
    Then I should be directed to the payment_done page
    And be informed with the message "Congratulations! Your order has been confirmed!"

  Scenario Outline: I want the correct items to be displayed in my cart
    Given I am on the view_cart page
    And I have items in my cart
    Then the correct number of items should be displayed
    And the correct items should be displayed
    Examples:

  Scenario: remove item from cart
    Given I am on the view_cart page
    And I have items in my cart
    When I click remove item
    Then the item should be removed from my cart




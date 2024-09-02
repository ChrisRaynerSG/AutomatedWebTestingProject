@PurchaseFeature
Feature: Purchase item from webpage

  @Happy
  @PurchaseFeature
  Scenario: add item to cart from homepage
    Given I am on the homepage
    When I click add to cart from products or home
    And the item is in stock
    Then I should see my cart updated

  @Happy
  @PurchaseFeature
  Scenario: add item to cart from products page
    Given I am on the products page
    When I click add to cart from products or home
    And the item is in stock
    Then I should see my cart updated

  @Happy
  @PurchaseFeature
  Scenario: add item to cart from items page
    Given I am on a specific items page
    When I click add to cart from item page
    And the item is in stock
    Then I should see my cart updated

  @Sad
  @PurchaseFeature
  Scenario: go to checkout not logged in
    Given I am on the view_cart page
    And I have an item in my cart
    And I am not logged in
    When I click Proceed to checkout
    Then I should be instructed to login or register

  @Happy
  @PurchaseFeature
  Scenario Outline: go to checkout while logged in
    Given I am on the view_cart page
    And I have an item in my cart
    And I am logged in with <email> and <password>
    When I click Proceed to checkout
    Then I should be directed to the checkout page
    And my address details should show <name>

    Examples:
    |email                 |password      |name          |
    |abc@abc.abc           |abc           |. abc abc     |
    |abc2@abc2.abc         |abc           |Mr. joe bloggs|




#
#  @Happy
#  @PurchaseFeature
#  Scenario: Place an order
#    Given I am on the checkout page
#    When I click place order
#    Then I should be directed to the payment page
#
#  @Sad
#  @PurchaseFeature
#  Scenario: invalid card details when making payment
#    Given I am on the payment page
#    And I have input the following card details
#    |        card number        | cvc | expiration date month | expiration date year |
#    |                           |123  |11                     |11                    |
#    |123                        |     |11                     |11                    |
#    |123                        |123  |                       |11                    |
#    |123                        |123  |11                     |                      |
#    When I click pay and confirm order
#    Then I should be informed what is missing
#    And remain on the payment page
#
#
#  @Happy
#  @PurchaseFeature
#  Scenario: make a payment
#    Given I am on the payment page
#    And I have input the following card details
#    |card number|cvc|expiration date month| expiration date year|
#    |123        |123|11                   |11                   |
#    When I click pay and confirm order
#    Then I should be directed to the payment_done page
#    And be informed with the message "Congratulations! Your order has been confirmed!"
#
#  @Happy
#  @PurchaseFeature
#  Scenario Outline: I want the correct items to be displayed in my cart
#    Given I am on the view_cart page
#    And I have items in my cart
#    Then the correct number of items should be displayed
#    And the correct items should be displayed
#    Examples:
#
#  @Happy
#  @PurchaseFeature
#  Scenario: remove item from cart
#    Given I am on the view_cart page
#    And I have items in my cart
#    When I click remove item
#    Then the item should be removed from my cart




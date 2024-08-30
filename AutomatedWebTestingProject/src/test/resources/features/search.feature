@search
Feature: As a user I want to be able to search for specific items, So that I can purchase something in particular

  @Happy
  @search
  Scenario: The search bar should appear on the all products page
    Given I am on the all products page
    Then I should see the product search bar

  @Happy
    @search
  Scenario Outline: Searching for an item should return the appropriate url with correct query parameter
    Given I am on the all products page
    And I enter "<input1>" in the search bar
    When I click the search button
    Then I am on the "<input2>" page
    Examples:
      | input1       | input2                                                        |
      | shirts       | https://automationexercise.com/products?search=shirts         |
      | dresses      | https://automationexercise.com/products?search=dresses        |
      | jeans        | https://automationexercise.com/products?search=jeans          |
      | jackets      | https://automationexercise.com/products?search=jackets        |
      | skirts       | https://automationexercise.com/products?search=skirts         |
      | pants        | https://automationexercise.com/products?search=pants          |
      | sweaters     | https://automationexercise.com/products?search=sweaters       |
      |              | https://automationexercise.com/products?search=               |
      | summer dress | https://automationexercise.com/products?search=summer%20dress |
      | shoes123     | https://automationexercise.com/products?search=shoes123       |
      | top!         | https://automationexercise.com/products?search=top%21         |


  @Happy
    @search
  Scenario Outline: The search bar should return relevant results
    Given I am on the all products page
    And I enter "<searchTerm>" in the search bar
    When I click the search button
    Then I should see items in the following categories:
      | <category1> |
      | <category2> |
      | <category3> |
      | <category4> |
      | <category5> |
      | <category6> |

    Examples:
      | searchTerm | category1 | category2 | category3 | category4 | category5 | category6 |
      | shirts     | shirt     | Tshirt    | T Shirt   | Top       | Tops      | T-Shirt   |
      | jeans      | Jeans     | jeans     | pants     | trouser   | clothing  | bottoms   |
      | dresses    | dress     | gown      | clothing  | outfit    | attire    | frock     |
      | dress      | dress     | gown      | outfit    | attire    | clothing  | -         |

  @Happy
  Scenario Outline: The search query should reflect the String entered into the search bar
    Given I am on the all products page
    And I enter "<searchTerm>" in the search bar
    When I click the search button
    Then I should see "<searchTerm>" in the search bar
    Examples:
      | searchTerm |
      | dress      |
      | jeans      |
      | tops       |
      | tops!tops  |
      | H&M        |



Feature: Display BookShelves
@sanity
  Scenario: 1 urbanlader Bookshelves
    Given User navigated to urbanladder
    When search for bookselves
    And select kids category
    And select in stock
    And priority low to high
    Then Print the first three bookshelves

@sanity
  Scenario: 2 Living
    Given user is on urbanladder
    When Hover mouse to living
    Then sub menus should be appeared and print it

  #Scenario: 3 GiftCard
    #Given on urbanladder Home page
    #When click on gift card
    #And click on type of giftcard
    #And put valid price add click next
    #And enter valid details and wrong email
    #Then alert should appear
#
  #Scenario: 4 GiftCardValidation
    #Given on urbanladder Home page
    #When click on gift card
    #And click on type of giftcard    #And put valid Details
    #Then checkout page should be validated

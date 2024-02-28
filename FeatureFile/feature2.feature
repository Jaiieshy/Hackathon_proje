Feature: Giftcard Details Validation

@sanity
  Scenario: 1 GiftCard
    Given on urbanladder Home page
    When click on gift card
    And click on type of giftcard
    And put valid price add click next
    And enter valid details and wrong email
    Then alert should appear
    And put the valid Details
    And checkout the page should be validated

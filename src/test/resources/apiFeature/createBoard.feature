Feature: Trello_test

  Scenario: Create_Board
    Given User sent request, um "cart" board zu erstellen
    Then Assert status code 200
    And Assert board name ist "cart"

Feature: Trello_test
  @wip
  Scenario: Create_Board
    Given User sent request, um "hasan" board zu erstellen
    Then Assert status code 200
    And Assert board name ist "hasan"

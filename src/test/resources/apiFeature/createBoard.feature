Feature: Trello_test
  @wip
  Scenario: Create_Board
    Given User sent request, um "api" board zu erstellen
    Then Assert status code
    And Assert board name ist "api"

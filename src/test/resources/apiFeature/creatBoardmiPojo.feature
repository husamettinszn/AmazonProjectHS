Feature:
  Scenario: Creat_Board_POJO
    Given POST request fuer Erstellung board "neu" mit pojo
    And nimm response mit pojo
    And assert,dass status code 200 ist
    And assert response "neu"

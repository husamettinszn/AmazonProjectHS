Feature: US002_unterkategorien_allmenu
@wip
  Scenario: Wenn der Benutzer eine beliebige Kategorie aus dem Menü ALLE auswählt, sollte er sehen können, dass die Unterkategorien aufgelistet sind.
    When der User offnet die Seite "amazon_url"
    Then der User klickt auf dem ALL-Hamburgermenu
    And der User waehlt die Kategorie "Fire TV" aus.
    Then der User verifiziert,dass der Anzahl der Unterkategorien 8 ist.
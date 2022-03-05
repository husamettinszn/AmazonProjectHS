Feature: US005_nach_der_preis_sortieren

  Scenario: TC_001_Beim Auflisten des Produkts soll der User nach "Price" sortieren können
    Given der User offnet die Seite "amazon_url"
    Then der User klickt auf dem ALL-Hamburgermenu
    And der User waehlt die Kategorie "Computer" aus.
    And der User waehlt die Unterkategorie "Audio" aus.
    And der User clickt auf dem Seller "Happy Home Srl" bei Filternmenu.
    And der User waehlt aus dem Dropdownmenu Sort by die Auswahl "Preis: aufsteigend" aus.
    Then der User sieht die Preis von niedrigsten zum hoechsten.
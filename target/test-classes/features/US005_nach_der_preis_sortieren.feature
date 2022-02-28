Feature: US005_nach_der_preis_sortieren

  Scenario: TC_001_Beim Auflisten des Produkts soll der User nach "Price" sortieren können
    Given der User offnet die Seite "amazon_url"
    Then der User klickt auf dem ALL-Hamburgermenu
    And der User waehlt die Kategorie "Electronics" aus.
    And der User waehlt die Unterkategorie "Camera & Photo" aus.
    And der User clickt auf dem Seller "FOTO KOESTER MUENSTER" bei Filternmenu.
    And der User clickt auf Sort by Schaltflaeche.
    And der User waehlt aus dem Dropdownmenu Sort by die Auswahl "Price: Low to High" aus.
    Then der User sieht die Preis von niedrigsten zum hoechsten.
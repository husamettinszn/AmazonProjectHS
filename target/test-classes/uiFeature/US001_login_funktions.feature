Feature: US001_login_funktions.feature

  Background:
    When der User offnet die Seite "amazon_url"
    Then der User klickt auf der Sign in Schaltfaeche

  Scenario: TC001_Der User soll mit gueltigen Daten einloggen kann.


    And der User gibt eine gueltige Email-Adresse "gueltige_Email_Adresse" in das Email-Textfeld ein.
    And der User klickt auf Continue Schaltflaeche.
    And der User gibt ein gueltiges Passwort "gueltiges_passwort" in das Passwort-Textfeld ein.
    And der User klickt auf Sign in Bestaetigungsschaltflaeche.
    Then der User verifiziert, dass In der Sign In Dropdown-Menu Sign Out Link angezeigt wird.


  Scenario: TC002_Der User soll mit guelltigen Daten icht einloggen kann.
    Then der User gibt eine ungueltige Email-Adresse "ungueltige_Email_Adresse" in das Email-Textfeld ein.
    And der User klickt auf Continue Schaltflaeche.
    Then der User verifiziert, dass "falsche_email_meldung" Meldung angezeigt wird.
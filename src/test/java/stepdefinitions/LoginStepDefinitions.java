package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefinitions {

    AmazonPage amazonPage = new AmazonPage();
    Actions actions = new Actions(Driver.getDriver());

    @When("der User offnet die Seite {string}")
    public void der_user_offnet_die_seite(String string) {
        Driver.getDriver().get(ConfigReader.getProperty(string));
        amazonPage.cookiesBestaetigungsSchaltflaeche.click();
    }

    @Then("der User klickt auf der Sign in Schaltfaeche")
    public void der_user_klickt_auf_der_sign_in_schaltfaeche() {
        amazonPage.signinSchaltFlaeche.click();

    }

    @Then("der User gibt eine gueltige Email-Adresse {string} in das Email-Textfeld ein.")
    public void der_user_gibt_eine_gueltige_email_adresse_in_das_email_textfeld_ein(String string) {
        amazonPage.emailTextfeld.sendKeys(ConfigReader.getProperty(string));

    }

    @Then("der User klickt auf Continue Schaltflaeche.")
    public void der_user_klickt_auf_continue_schaltflaeche() {
        amazonPage.continueSchaltflaeche.click();

    }

    @Then("der User gibt ein gueltiges Passwort {string} in das Passwort-Textfeld ein.")
    public void der_user_gibt_ein_gueltiges_passwort_in_das_passwort_textfeld_ein(String string) {
        amazonPage.passwortTextfeld.sendKeys(ConfigReader.getProperty(string));

    }

    @And("der User klickt auf Sign in Bestaetigungsschaltflaeche.")
    public void derUserKlicktAufSignInBestaetigungsschaltflaeche() {
        amazonPage.signinBestaetung.click();
    }

    @Then("der User verifiziert, dass In der Sign In Dropdown-Menu Sign Out Link angezeigt wird.")
    public void der_user_verifiziert_dass_in_der_sign_in_dropdown_menu_sign_out_link_angezeigt_wird() throws InterruptedException {

        actions.moveToElement(amazonPage.signinSchaltFlaeche).perform();

        Assert.assertTrue(amazonPage.signoutLink.isDisplayed());
        amazonPage.signoutLink.click();
    }

    @Then("der User gibt eine ungueltige Email-Adresse {string} in das Email-Textfeld ein.")
    public void derUserGibtEineUngueltigeEmailAdresseInDasEmailTextfeldEin(String arg0) {
        amazonPage.emailTextfeld.sendKeys(arg0);
    }

    @Then("der User verifiziert, dass {string} Meldung angezeigt wird.")
    public void derUserVerifiziertDassMeldungAngezeigtWird(String arg0) {
        System.out.println(amazonPage.falscheEmailMeldung.getText());
        Assert.assertTrue(amazonPage.falscheEmailMeldung.getText().equals(ConfigReader.getProperty(arg0)));
    }

}

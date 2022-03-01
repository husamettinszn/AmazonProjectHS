package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonPage;
import utilities.Driver;

public class SortStepDefinitions {
    AmazonPage amazonPage = new AmazonPage();
    Actions actions = new Actions(Driver.getDriver());

    @And("der User waehlt die Unterkategorie {string} aus.")
    public void derUserWaehltDieUnterkategorieAus(String arg0) {

        for (int i=0; i<=amazonPage.unterTitel.size()-3; i++){
            if(amazonPage.unterTitel.get(i).getText().contains(arg0)){
                amazonPage.unterTitel.get(i).click();
            }
        }
    }

    @And("der User clickt auf dem Seller {string} bei Filternmenu.")
    public void derUserClicktAufDemSellerBeiFilternmenu(String arg0) {
        for (int i=44; i<=54; i++){
            System.out.println(amazonPage.sellerSort.get(i).getText());
            if(amazonPage.sellerSort.get(i).getText().contains(arg0)){
                amazonPage.sellerSort.get(i).click();
            }
        }
    }

    @And("der User waehlt aus dem Dropdownmenu Sort by die Auswahl {string} aus.")
    public void derUserWaehltAusDemDropdownmenuSortByDieAuswahlAus(String arg0) {
        Select select = new Select(amazonPage.sortDropdown);

        select.selectByVisibleText(arg0);
    }

    @Then("der User sieht die Preis von niedrigsten zum hoechsten.")
    public void derUserSiehtDiePreisVonNiedrigstenZumHoechsten() {
    }
}

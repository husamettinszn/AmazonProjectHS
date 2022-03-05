package ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ui.pages.AmazonPage;
import ui.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class SortStepDefinitions {
    AmazonPage amazonPage = new AmazonPage();
    Actions actions = new Actions(Driver.getDriver());

    @And("der User waehlt die Unterkategorie {string} aus.")
    public void derUserWaehltDieUnterkategorieAus(String arg0) {

        for (int i = 0; i <= amazonPage.unterTitel.size() - 3; i++) {
            if (amazonPage.unterTitel.get(i).getText().contains(arg0)) {
                amazonPage.unterTitel.get(i).click();
            }
        }
    }

    @And("der User clickt auf dem Seller {string} bei Filternmenu.")
    public void derUserClicktAufDemSellerBeiFilternmenu(String arg0) {
        System.out.println(amazonPage.sellerSort.size());
        for (int i = 44; i < amazonPage.sellerSort.size(); i++) {
            System.out.println(amazonPage.sellerSort.get(i).getText());
            if (amazonPage.sellerSort.get(i).getText().contains(arg0)) {
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

        List<Double> preisList = new ArrayList<>();
        for (WebElement w : amazonPage.preiceList
        ) {
            preisList.add(Double.valueOf(w.getText().replace("€", "").replace(",",".")));
        }

        for (int i=0; i<preisList.size(); i++){
            if (preisList.get(i+1)<preisList.get(i)){
                System.out.println("Nicht aufsteigend");
                break;
            }
        }
    }
}

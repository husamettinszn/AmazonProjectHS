package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllMenuUnterkategorienStepDefinitions {

    AmazonPage amazonPage = new AmazonPage();
    Actions actions = new Actions(Driver.getDriver());

    @Then("der User klickt auf dem ALL-Hamburgermenu")
    public void derUserKlicktAufDemALLHamburgermenu() {
        amazonPage.allCategorie.click();
    }

    @And("der User waehlt die Kategorie {string} aus.")
    public void derUserWaehltDieKategorieAus(String arg0) {

        for (int i = 0; i < amazonPage.items.size(); i++) {
            if (amazonPage.items.get(i).getText().contains(arg0)) {
                amazonPage.items.get(i).click();
            }
        }

    }

    @Then("der User verifiziert,dass der Anzahl der Unterkategorien {int} ist.")
    public void derUserVerifiziertDassDerAnzahlDerUnterkategorienIst(int arg0) {
        System.out.println(amazonPage.unterTitel.size());
        Assert.assertTrue(amazonPage.unterTitel.size() - 5 == arg0);

        List<String> titelList = new ArrayList<>();
        for (WebElement w : amazonPage.unterTitel
        ) {
            //System.out.println(w.getText());
            titelList.add(w.getText());
        }
        System.out.println(titelList);

        List<String> vorhandeneList = new ArrayList<>();

        vorhandeneList.addAll(Arrays.asList("HAUPTMENÜ", "Alle Fire TV-Geräte", "Streaming-Geräte","Fire TV Smart-TVs", "Zubehör", "","Filme, Serien Und Mehr", "Prime Video - Enthalten in Prime", "Prime Video - Alle Videos", "Apps & Spiele für Fire TV", "Amazon Photos", ""));
        System.out.println(vorhandeneList);

        Assert.assertTrue(titelList.containsAll(vorhandeneList));


    }


}

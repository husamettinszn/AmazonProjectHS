package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "nav-link-accountList")
    public WebElement signinSchaltFlaeche;

    @FindBy(xpath ="//a[@data-csa-c-id='cwdzlg-ymhe5f-p530gh-nr8s15']")
    public WebElement signinSchaltFlaecheEingeloggt;

    @FindBy(id = "ap_email")
    public WebElement emailTextfeld;

    @FindBy(xpath = "//span[@id='continue']")
    public WebElement continueSchaltflaeche;

    @FindBy(id = "ap_password")
    public WebElement passwortTextfeld;

    @FindBy(id = "signInSubmit")
    public WebElement signinBestaetung;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signoutLink;
    @FindBy(id = "sp-cc-accept")
    public WebElement cookiesBestaetigungsSchaltflaeche;

    @FindBy(xpath = "//span[@class='a-list-item']")
    public WebElement falscheEmailMeldung;

    @FindBy(id = "nav-hamburger-menu")
    public WebElement allCategorie;

    @FindBy(xpath = "//a[@class='hmenu-item']//div")
    public List<WebElement> items;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//li")
    public List<WebElement> unterTitel;

    @FindBy(id = "a-autoid-0")
    public WebElement acceptCookies;

    @FindBy(xpath = "//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']//li")
    public List<WebElement> sellerSort;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    public WebElement sortDropdown;
}

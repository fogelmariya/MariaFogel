package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement userName;

    @FindBy(className = "benefit-icon")
    private ElementsCollection homeImages;

    @FindBy(className = "benefit-txt")
    private ElementsCollection textsUnderImages;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTextTop;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainTextDown;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement services;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection servicesDropdown;

    @FindBy(css = ".fa-caret-down")
    private SelenideElement servicesLeft;

    @FindBy(css = ".sub > li")
    private ElementsCollection servicesDropdownLeft;


    public void openSite(){
    }

    public void checkHomePageTitle() {
                Assert.assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void login(String login, String password){
//        $(".profile-photo").click();
//        $("#Name").sendKeys(login);
//        $("#Password").sendKeys(password);
//        $(".form-horizontal [type='submit']").click();

        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserName(String name) {
        userName.shouldHave(Condition.text(name));
    }

    public void checkMainInterface() {
        homeImages.shouldHaveSize(4);
        for (SelenideElement image : homeImages) {
            image.should(Condition.visible);
        }

        textsUnderImages.shouldHaveSize(4);
        for (SelenideElement text : textsUnderImages) {
            text.should(Condition.visible);
        }

        mainTextDown.should(Condition.visible);
        mainTextTop.should(Condition.visible);
    }

    public void checkServiceDropdown(List<String> servicesexpected) {
        services.click();
        servicesDropdown.shouldHaveSize(8);
        servicesDropdown.shouldHave(CollectionCondition.texts(servicesexpected));
    }

    public void checkServiceDropdownLeft(List<String> servicesexpected) {
        servicesLeft.click();

        for (String service : servicesDropdownLeft.texts()) {
            Assert.assertTrue(servicesexpected.contains(service.toUpperCase()));
        }
    }

    public void openDifferentElementsPage() {
        services.click();
        servicesDropdown.get(6).click();
        Assert.assertEquals(getWebDriver().getTitle(), "Different Element");
    }

    public void openDatesPage() {
        services.click();
        servicesDropdown.get(1).click();
        Assert.assertEquals(getWebDriver().getTitle(), "Dates");
    }
}

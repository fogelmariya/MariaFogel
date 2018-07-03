package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class HomePageCucumber {

    public HomePageCucumber() {
        page(this);
    }

    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo")
    private static SelenideElement profilePhoto;

    @FindBy(css = ".logout")
    private static SelenideElement logOutButton;

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


    @Step
    @Given("I'm on the Home Page")
    public void openSite() {
        open("https://epam.github.io/JDI/");
    }

    @Step
    @Then("The browser title is Home Page")
    public void checkHomePageTitle() {
        Assert.assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    public void login(Users user) {
        $(".profile-photo").click();
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
    }

    @Step
    public static void logout() {
        profilePhoto.click();
        logOutButton.click();
    }

    @Step
    @When("I login as user (.+) with password (.+)")
    public void loginCucumber(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    @Then("The user icon  is displayed on the header and have name (.+)")
    public void checkUserName(String name) {
        userName.shouldHave(Condition.text(name));
    }

    @Step
    @Then("In the page are 4 images and they have text under them and there are 2 main text")
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

    @Step
    @Then("Service dropdown on the top menu has 8 items with necessary texts (.+)")
    public void checkServiceDropdown(String s1) {
        services.click();
        servicesDropdown.shouldHaveSize(8);

        for (SelenideElement service : servicesDropdown) {
            Assert.assertTrue(s1.contains(service.getText()));
        }
        //servicesDropdown.shouldHave(CollectionCondition.texts(s1.toUpperCase()));
    }

    @Step
    @Then("Service dropdown on the left menu has 8 items with necessary texts (.+)")
    public void checkServiceDropdownLeft(String s1) {
        servicesLeft.click();

        System.out.println(servicesDropdownLeft.texts());
        for (SelenideElement service : servicesDropdownLeft) {
            Assert.assertTrue(s1.contains(service.getText().toUpperCase()));
        }
    }

    @Step
    @When("I open Different Element page by Service dropdown on the top menu")
    public void openDifferentElementsPage() {
        services.click();
        servicesDropdown.get(6).click();
    }

    @Step
    @When("I open Dates page")
    public void openDatesPage() {
        services.click();
        servicesDropdown.get(1).click();
    }

    @Step
    @Then("The browser title is Dates")
    public void checkDatesPageOpened() {
        Assert.assertEquals(getWebDriver().getTitle(), "Dates");
    }

    @And("^I open User Table Page through the header menu Service$")
    public void openUserTablePage() {
        services.click();
        servicesDropdown.get(4).click();

    }

    @And("^I am on Users Table Page$")
    public void checkUsersTablePageOpened() {
        Assert.assertEquals(getWebDriver().getTitle(), "User Table");
    }
}


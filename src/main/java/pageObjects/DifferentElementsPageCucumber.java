package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DifferentElementsPageCucumber {

    public DifferentElementsPageCucumber(){
        page(this);
    }

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropdown;

    @FindBy(css = ".uui-form-element > option")
    private ElementsCollection colorsList;

    @FindBy(css = ".main-content-hg .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "[Name = 'log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".logs> li")
    private ElementsCollection log;

    @Step
    @Then("The browser title is Different Element")
    public void checkDifferentElementsPageOpened(){
        Assert.assertEquals(getWebDriver().getTitle(), "Different Element");
    }

    @Step
    @Then("On the page are 4 checkboxes, 4 radios, 1 dropdown, 2 buttons")
    public void checkElements() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement element : checkboxes) {
            element.should(Condition.visible);
        }

        radios.shouldHaveSize(4);
        for (SelenideElement element : radios) {
            element.should(Condition.visible);
        }

        colorsDropdown.shouldBe(Condition.visible);

        buttons.shouldHaveSize(2);
        for (SelenideElement element : buttons) {
            element.should(Condition.visible);
        }
    }

    @Step
    @Then("there is Right Section")
    public void checkRightSection() {
        rightSection.should(Condition.visible);
    }

    @Step
    @Then("there is Left Section")
    public void checkLeftSection() {
        leftSection.should(Condition.visible);
    }

    @Step
    @When("I select checkboxes (.+)")
    public void selectCheckboxes(String elementsEnum) {
        for (SelenideElement element : checkboxes) {
            if (elementsEnum.equals(element.getText())) {
                element.find("input").click();
                element.find("input").shouldBe(checked);
            }
        }
    }

    @Step
    public void checkLog(String string) {
        boolean exist = false;
        for (SelenideElement text: $$(".logs> li")) {
            if (text.getText().contains(string))
                exist = true;
        }
        System.out.println(string);
        System.out.println($$(".logs> li").texts());
        Assert.assertTrue(exist);
    }

    @Step
    @Then("Log contains row (.+) has value (.+)")
    public void checkLogValue(String element, String value) {
        checkLog(element + ": value changed to " + value);
    }

    @Step
    @Then("Log contains row (.+) has condition (.+)")
    public void checkLogCondition(String element, String condition) {
        checkLog(element + ": condition changed to " + condition);
    }

    @Step
    @When("I select radio (.+)")
    public void checkRadioButtons(String elementToSelect) {
        for (SelenideElement radio : radios) {
            if (radio.getText().equals(elementToSelect)) {
                radio.click();
                radio.find("input").shouldBe(checked);
            }
        }
    }

    @Step
    @When("I select in dropdown (.+)")
    public void checkDropdown(String elementToSelect) {
        colorsDropdown.click();
        for (SelenideElement color : colorsList) {
            System.out.println(color.getText());
            if (color.getText().equals(elementToSelect)) {
                color.click();
            }
        }
        colorsDropdown.shouldHave(text(elementToSelect));
    }

    @Step
    @When("I unselect and assert checkboxes (.+)")
    public void checkUnselect(String elementToUnselect) {
        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.getText().equals(elementToUnselect)) {
                checkbox.find("input").click();
                checkbox.find("input").shouldNotBe(checked);
            }
        }
    }
}

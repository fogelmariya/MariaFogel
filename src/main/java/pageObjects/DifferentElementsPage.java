package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

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

    @FindBy(name = "log-sidebar")
    private SelenideElement rightSection;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".logs> li")
    private ElementsCollection log;

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

    public void checkRightSection() {
        rightSection.should(Condition.visible);
    }

    public void checkLeftSection() {
        leftSection.should(Condition.visible);
    }

    public void selectcheckboxes(String elementToSelect) {
        for (SelenideElement element : checkboxes) {
            if (elementToSelect.equals(element.getText())) {
                element.find("input").click();
                element.find("input").shouldBe(checked);
            }
        }
    }

    public void checkLog(String string) {
        boolean exist = false;
        for (SelenideElement text: $$(".logs> li")) {
           if (text.getText().contains(string))
               exist = true;
        }
        Assert.assertTrue(exist);
    }

    public void checkLogValue(String element, String value) {
        checkLog(element + ": value changed to " + value);
    }

    public void checkLogCondition(String element, boolean condition) {
        checkLog(element + ": condition changed to " + condition);
    }

    public void checkRadioButtons(String elementToSelect) {
        for (SelenideElement radio : radios) {
            if (radio.getText().equals(elementToSelect)) {
                radio.click();
                radio.find("input").shouldBe(checked);
            }
        }
    }

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

    public void checkUnselect(String elementToUnselect) {
        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.getText().equals(elementToUnselect)) {
                checkbox.find("input").click();
                checkbox.find("input").shouldNotBe(checked);
            }
        }
    }
}

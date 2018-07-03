package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.UserTableEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class UserTablePageCucumber {

    public UserTablePageCucumber() {
        page(this);
    }

    @FindBy(css = "#user-table")
    private SelenideElement userTable;

    @FindBy(css = ".info-panel-body-log")
    private SelenideElement log;

    @FindBy(css = ".info-panel-body-result")
    private SelenideElement result;

    @FindBy(css = "#user-table tr")
    private ElementsCollection rows;

    @FindBy(css = "#user-table tr th")
    private ElementsCollection firstRow;

    @FindBy(css = ".user-descr span")
    private ElementsCollection userDescriptionText;

    @FindBy(css = ".user-descr [type='checkbox']")
    private ElementsCollection userDescriptionCheckbox;

    @Step
    @And("^User Table Page's interface contains correct elements$")
    public void checkUserPageInterface() {
        userTable.shouldBe(Condition.visible);
        log.shouldBe(Condition.visible);
        result.shouldBe(Condition.visible);
    }

    @When("^I check Number and User columns of Users table $")
    public void checkNumberAndUserColumnsOfUsersTable() {
        rows.shouldHaveSize(7);
    }

    @Then("^User table contain correct values for numbers (.+) and users (.+)$")
    public void userTableContainCorrectValuesForNumbersAndUsers(String i, String name) {

        Assert.assertTrue(rows.get(Integer.parseInt(i) + 1).text().contains(name));
    }

    @Then("^User table contain correct values for numbers and users$")
    public void userTableContainCorrectValuesForNumbersAndUsers() {
        for (int i = 1; i <= 6; i++) {
            Assert.assertEquals(rows.get(i).$$("td").get(2).getText(), UserTableEnum.getUsers().get(i - 1));
            //System.out.println(rows.get(i).$$("td").get(2).getText());
        }

    }

    @When("^I check Description column of Users table$")
    public void checkDescriptionColumnOfUsersTable() {
        Assert.assertEquals(firstRow.get(3).getText(), "Desciption");
    }

    @Then("^All cells of 'Description' column contains text$")
    public void allCellsOfDescriptionColumnContainsText() {
        for (int i = 0; i < userDescriptionText.size(); i++) {
            Assert.assertEquals(userDescriptionText.get(i).getText().replaceAll("\\n", " "),
                    UserTableEnum.getDescriptions().get(i));
        }

    }

    @When("^I set 'vip' status to Sergey Ivan$")
    public void setVipStatusToSergeyIvan() {
        userDescriptionCheckbox.get(1).click();
    }

    @Then("^'Log' section shows a log row in format: FIELDNAME: condition changed to STATUS$")
    public void checkLogSection() {
        boolean exist = false;
        for (SelenideElement text: $$(".logs> li")) {
            if (text.getText().contains("Vip: condition changed to true"))
                exist = true;
        }

        Assert.assertTrue(exist);
    }

    @When("^I click on dropdown in column Type for user Roman$")
    public void iClickOnDropdownInColumnTypeForUserRoman() {
        for (String status: UserTableEnum.getStatus()) {
            Assert.assertTrue(rows.get(2).$$("select").toString().contains(status));
        }

    }

//    @Then("^'Log' section shows a log row in format: (.+): condition changed to (.+)")
//    public void checkLogSection(String field, String status) {
//        boolean exist = false;
//        for (SelenideElement text: $$(".logs> li")) {
//            if (text.getText().contains(field + ": condition changed to " + status))
//                exist = true;
//        }
//
//        Assert.assertTrue(exist);
//    }
}

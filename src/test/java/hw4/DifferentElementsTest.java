package hw4;

import base.BaseSelenide;
import com.codeborne.selenide.Configuration;
import enums.Services;
import enums.Users;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPage;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.CheckboxesEnum.WATER;
import static enums.CheckboxesEnum.WIND;
import static enums.ColorsEnum.COLOR;
import static enums.ColorsEnum.YELLOW;
import static enums.MetalsEnum.METALS;
import static enums.MetalsEnum.SELEN;

public class DifferentElementsTest extends BaseSelenide {

    private WebDriver driver;
    private HomePageSelenide homePage;
    private DifferentElementsPage differentElementsPage;

    @BeforeSuite
    public void before() {
        Configuration.screenshots = true;
        homePage = page(HomePageSelenide.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void servicePageTest() {
        //1 Open test site by URL
        open("https://epam.github.io/JDI/");

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName(Users.PITER_CHAILOVSKII.userName);

        //5 Check interface on Home page, it contains all needed elements.
        homePage.checkMainInterface();

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServiceDropdown(Services.getServices());

        //7 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServiceDropdownLeft(Services.getServices());

        //8 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();

        //9 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkElements();

        //10 Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //11 Assert that there is Left Section
        differentElementsPage.checkLeftSection();

        //12 Select checkboxes
        differentElementsPage.selectcheckboxes(WATER.text);
        differentElementsPage.selectcheckboxes(WIND.text);

        //13 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
         differentElementsPage.checkLogCondition(WIND.text, true);
         differentElementsPage.checkLogCondition(WATER.text, true);

        //14 Select radio
        differentElementsPage.checkRadioButtons(SELEN.text);

        //15 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPage.checkLogValue(METALS.text, SELEN.text);

        //16 Select in dropdown
        differentElementsPage.checkDropdown(YELLOW.text);

        //17 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.checkLogValue(COLOR.text, YELLOW.text);

        //18 Unselect and assert checkboxes
        differentElementsPage.checkUnselect(WATER.text);
        differentElementsPage.checkUnselect(WIND.text);

        //19 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogCondition(WIND.text, false);
        differentElementsPage.checkLogCondition(WATER.text, false);
    }
}

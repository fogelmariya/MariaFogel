package hw5;

import base.BaseSelenide;
import com.codeborne.selenide.Configuration;
import enums.Services;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPage;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.ColorsEnum.*;
import static enums.ElementsEnum.WATER;
import static enums.ElementsEnum.WIND;
import static enums.MetalsEnum.METALS;
import static enums.MetalsEnum.SELEN;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Different Element page")
@Story("Login and check interface")
@Listeners({AllureAttachmentListener.class})
public class SimpleJenkinsTest extends BaseSelenide {
    private HomePageSelenide homePage;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "chrome";

        Configuration.screenshots = true;
        homePage = page(HomePageSelenide.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Flaky
    @Test
    public void servicesAndDifferentElementsPageTest() {
        //1 Open test site by URL
        homePage.openSite();

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName(PITER_CHAILOVSKII);

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
        differentElementsPage.selectCheckboxes(WATER);
        differentElementsPage.selectCheckboxes(WIND);

        //13 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogCondition(WIND.text, "true");
        differentElementsPage.checkLogCondition(WATER.text, "true");

        //14 Select radio
        differentElementsPage.checkRadioButtons(SELEN);

        //15 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPage.checkLogValue(METALS.text, SELEN.text);

        //16 Select in dropdown
        differentElementsPage.checkDropdown(YELLOW);

        //17 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.checkLogValue(COLORS.text, GREEN.text);

        //18 Unselect and assert checkboxes
        differentElementsPage.checkUnselect(WATER.text);
        differentElementsPage.checkUnselect(WIND.text);

        //19 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogCondition(WIND.text, "false");
        differentElementsPage.checkLogCondition(WATER.text, "false");
    }
}

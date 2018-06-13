package hw4;

import base.BaseSelenide;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPage;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Dates page")
@Story("Login and check interface")
@Listeners({AllureAttachmentListener.class})
public class DatesPageTest extends BaseSelenide {

    private HomePageSelenide homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "chrome";
        homePage = page(HomePageSelenide.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void datesPageTest() {
        //1 Open test site by URL
        homePage.openSite();

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        homePage.openDatesPage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setSliderRange(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
         datesPage.checkLog(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
         datesPage.setSliderRange(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setSliderRange(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog(100, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.setSliderRange(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog(30, 70);

    }
}

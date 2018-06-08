package base;

import org.testng.annotations.AfterSuite;
import pageObjects.DatesPage;
import pageObjects.DifferentElementsPage;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseSelenide {

    private HomePageSelenide homePage;
    private DifferentElementsPage differentElementsPage;
    private DatesPage datesPage;

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
//        homePage = page(HomePageSelenide.class);
//        differentElementsPage = page(DifferentElementsPage.class);
//        datesPage = page(DatesPage.class);
        getWebDriver().close();
    }
}

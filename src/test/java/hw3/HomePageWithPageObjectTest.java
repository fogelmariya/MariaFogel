package hw3;

import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Feature("Home page")
@Story("Login and check interface")
@Listeners({AllureAttachmentListener.class})
public class HomePageWithPageObjectTest {

    private List<String> textUnderImageExpected = Arrays.asList(
            "To include good practices and ideas from successful EPAM project",
            "To be flexible and customizable", "To be multiplatform",
            "Already have good base (about 20 internal and some external projects), wish to get more…");

    private List<String> topItemsExpected = Arrays.asList("home", "contact form", "service", "metals & colors");
    private String mainTextTopExpected = "EPAM FRAMEWORK WISHES…";
    private String mainTextDownExpected = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT" +
            " LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA" +
            " COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private String subHeaderText = "JDI GITHUB";
    private String textLink = "https://github.com/epam/JDI";

    private WebDriver driver;
    private ChromeOptions options;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @Flaky
    @Test
    public void homePageTest() {
        //2 Open test site by URL
        homePage.open(driver);

        //3 Assert Browser title
        homePage.checkHomePageTitle(driver);

        //4 Perform login
        homePage.login("epam", "1234");

        //5 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName("PITER CHAILOVSKII");

        //6 Assert Browser title
        homePage.checkHomePageTitle(driver);

        //7 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkHeaderItems(topItemsExpected);

        //8 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkHomeImages();

        //9 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextUnderImages(textUnderImageExpected);

        //10 Assert a text of the main header
        homePage.checkMainHeaderText(mainTextTopExpected, mainTextDownExpected);

        //11 Assert a text of the sub header
        homePage.checkSubHeaderText(subHeaderText);


        //12 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkSubHeaderLink(textLink);

        //13 Assert that there is Left Section
        homePage.checkLeftSectionExist();

        //14 Assert that there is Footer
        homePage.checkFooterExist();

        driver.close();
    }

}

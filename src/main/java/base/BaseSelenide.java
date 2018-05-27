package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseSelenide {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        browser = "chrome";
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getWebDriver().close();
    }
}

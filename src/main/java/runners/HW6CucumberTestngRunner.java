package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;
import static pageObjects.HomePageCucumber.logout;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects")
public class HW6CucumberTestngRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "chrome";
    }

    @AfterMethod
    public void after() {
        logout();
        close();
    }

}

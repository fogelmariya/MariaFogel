package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSelenide {


    @BeforeSuite
    public void before(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "chrome";

    }

    @AfterSuite()
    public void tearDown() {

       // getWebDriver().close();
    }
}

package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseSelenide {


    @BeforeClass
    public void before(){
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        Configuration.browser = "chrome";

    }

    @AfterSuite()
    public void tearDown() {

       // getWebDriver().close();
    }
}

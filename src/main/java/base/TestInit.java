package base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import site.JdiSite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class TestInit extends TestNGBase {
    private WebDriver driver;
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JdiSite.class);
        logger.info("Run Tests");
    }
}

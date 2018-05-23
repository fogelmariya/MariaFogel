package hw2.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class SimpleTestWithAnnotations {

    private WebDriver driver;

    @BeforeSuite
    public void setUp2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void tearDown() {
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown2() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterTest
    public void tearDown3() {
        driver.close();
    }

    @AfterMethod
    public void setUp3() {
        System.out.println(driver.getTitle());
    }
    @Test
    public void simpleSeleniumTestOne() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals(driver.getTitle(), "Index Page");

        WebElement userIcon = driver.findElement(By.cssSelector(".fa-user"));
        userIcon.click();

        driver.findElement(By.cssSelector("#Login")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
        }
}

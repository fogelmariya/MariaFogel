package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TextUnderImagesTest {

    private WebDriver driver;
    private List<WebElement> hometext;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/");
        hometext = driver.findElements(By.className("benefit-txt"));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
    @DataProvider(parallel = true)
    public Object[][] textDataProvider() {
        return new Object[][]{
                {0, "To include good practices and ideas from successful EPAM project"},
                {1, "To be flexible and customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base (about 20 internal and some external projects), wish to get more…"}
        };
    }

    @Test(dataProvider = "textDataProvider")
    public void textUnderImagesTest(int num, String txt) {

        for (WebElement text : hometext) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
    }
}

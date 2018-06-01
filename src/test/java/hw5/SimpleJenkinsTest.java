package hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SimpleJenkinsTest {

    private List<String> textUnderImageExpected = Arrays.asList(
            "To include good practices and ideas from successful EPAM project",
            "To be flexible and customizable", "To be multiplatform",
            "Already have good base (about 20 internal and some external projects), wish to get more…");

    @Test
    public void homePageTest() {
        //2 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/");

        //3 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //4 Perform login
        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();

        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal [type='submit']")).click();

        //5 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //6 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Pag");

        //7 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> topElements = driver.findElements(By.cssSelector(".nav > li"));
        Assert.assertEquals(topElements.size(), 4);
        Assert.assertEquals(topElements.get(0).getText(), "HOME");
        Assert.assertEquals(topElements.get(1).getText().toLowerCase(), "contact form");
        Assert.assertEquals(topElements.get(2).getText().toLowerCase().replaceAll(" ", ""), "service");
        Assert.assertEquals(topElements.get(3).getText().toLowerCase(), "metals & colors");

        //8 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> homeImage = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(homeImage.size(), 4);
        for (WebElement image : homeImage) {
            assertTrue(image.isDisplayed());
        }

        //9 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> homeText = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(homeText.size(), 4);
        for (WebElement text : homeText) {
            assertTrue(text.isDisplayed());
            assertTrue(textUnderImageExpected.contains(text.getText().replaceAll("\\n", " ")));
        }

        //10 Assert a text of the main header
        WebElement mainTextTop = driver.findElement(By.cssSelector("h3.main-title"));
        Assert.assertTrue(mainTextTop.isDisplayed());
        Assert.assertEquals(mainTextTop.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainTextDown = driver.findElement(By.cssSelector("p.main-txt"));
        Assert.assertTrue(mainTextDown.isDisplayed());
        Assert.assertEquals(mainTextDown.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT" +
                " LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA" +
                " COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11 Assert a text of the sub header
        WebElement subHeadText = driver.findElements(By.cssSelector("h3.text-center")).get(1);
        Assert.assertTrue(subHeadText.isDisplayed());
        Assert.assertEquals(subHeadText.getText(), "JDI GITHUB");

        //12 Assert that JDI GITHUB is a link and has a proper URL
        Assert.assertEquals(subHeadText.findElement(By.tagName("a")).getAttribute("href"), "https://github.com/epam/JDI");

        //13 Assert that there is Left Section
        Assert.assertTrue(driver.findElement(By.cssSelector(".sidebar-menu")).isDisplayed());

        //14 Assert that there is Footer
        Assert.assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());

        //15 Close Browser
        driver.close();
    }
}

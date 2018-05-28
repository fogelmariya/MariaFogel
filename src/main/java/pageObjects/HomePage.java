package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class HomePage {
    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement userName;


    @FindBy(css = ".nav > li")
    private List<WebElement> topItems;

    @FindBy(className = "benefit-icon")
    private List<WebElement> homeImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textsUnderImages;

    @FindBy(css = "h3.main-title")
    private WebElement mainTextTop;

    @FindBy(css = "p.main-txt")
    private WebElement mainTextDown;

    @FindBy(css = ".text-center > a")
    private WebElement subHeaderText;

    @FindBy(css = ".sidebar-menu")
    private WebElement leftSection;

    @FindBy(tagName = "footer")
    private WebElement footer;

    public void openSite(){
        open("https://epam.github.io/JDI/");
    }

    public void login(String login, String password){
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkHomePageTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserName(String name) {
        Assert.assertEquals(userName.getText(), name);
    }

    public void checkHeaderItems(List<String > topItemsExpected) {
        Assert.assertEquals(topItems.size(), 4);

        for (WebElement topItem: topItems) {
            Assert.assertTrue(topItemsExpected.contains(topItem.getText().toLowerCase()));
        }
    }

    public void checkHomeImages() {
        Assert.assertEquals(homeImages.size(), 4);
        for (WebElement image : homeImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkTextUnderImages(List<String> textUnderImageExpected) {
        Assert.assertEquals(textsUnderImages.size(), 4);
        for (WebElement text : textsUnderImages) {
            assertTrue(text.isDisplayed());
            assertTrue(textUnderImageExpected.contains(text.getText().replaceAll("\\n", " ")));
        }
    }

    public void checkMainHeaderText(String mainTextTopExpected, String mainTextDownExpected) {
        Assert.assertTrue(mainTextTop.isDisplayed());
        Assert.assertEquals(mainTextTop.getText(), mainTextTopExpected);
        Assert.assertTrue(mainTextDown.isDisplayed());
        Assert.assertEquals(mainTextDown.getText(), mainTextDownExpected);
    }

    public void checkSubHeaderText(String text) {
        Assert.assertEquals(subHeaderText.getText(), text);
    }

    public void checkSubHeaderLink(String textLink) {
        Assert.assertEquals(subHeaderText.getAttribute("href"), textLink);
    }

    public void checkLeftSectionExist() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterExist() {
        Assert.assertTrue(footer.isDisplayed());
    }
}

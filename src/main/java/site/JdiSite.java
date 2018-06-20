package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.MetalsColorsData;
import entities.User;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import site.forms.LoginnForm;
import site.pages.HomePageJdi;
import site.pages.MetalsColorsPage;
import site.sections.Header;


@JSite("https://epam.github.io/JDI")
public class JdiSite extends WebSite {

    public static HomePageJdi homePage;
    public static LoginnForm loginForm;
    public static Header header;

    @JFindBy(css = ".profile-photo")
    private static Label profilePhoto;

    @FindBy(css = ".logout .submit")
    private static Button logOutButton;

    @JFindBy(css = ".m-l8")
    public static Header headerMenu;

    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    @Step
    public static void logout() {
        profilePhoto.click();
        logOutButton.click();
    }

    @Step
    public static void openPage(String page) {
        headerMenu.select(page);
        // TODO what happened in case if we open another page ?
        metalsColorsPage.checkOpened();
    }

    @Step
    public static void fillMetalsColorsForm() {
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(new MetalsColorsData());
    }
}

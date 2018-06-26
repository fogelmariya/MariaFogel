package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import enums.HeaderMenuItems;
import org.openqa.selenium.support.FindBy;
import site.elements.MyMenu;

@JPage(url = "/index.html", title = "Home Page")
public class HomePageJdi extends WebPage {

    @FindBy(css = ".nav")
    public MyMenu<HeaderMenuItems> headerMenu;
}

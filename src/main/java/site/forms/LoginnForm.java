package site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginnForm extends Form<User> {
    @FindBy(id="Name") public TextField login;
    @FindBy(id="Password") public TextField password;

    @Css("[type=submit]") public Button enter;
}

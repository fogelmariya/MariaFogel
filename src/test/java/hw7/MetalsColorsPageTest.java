package hw7;

import base.TestInit;
import entities.MetalsColorsData;
import entities.User;
import enums.Users;
import org.testng.annotations.Test;

import static site.JdiSite.*;

public class MetalsColorsPageTest extends TestInit {

    @Test
    public void metalsColorsDefaultTest() {
        //1 Login on JDI site as User
        homePage.open();
        login(new User(Users.PITER_CHAILOVSKII.login, Users.PITER_CHAILOVSKII.password));
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        openMetalsColorsPage();
        metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        MetalsColorsData metalsColorsData = new MetalsColorsData();
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);

        //4 Submit form Metals & Colors
        metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data  below:
        metalsColorsPage.metalsColorsResultSection.checkResult(metalsColorsData);

    }
}

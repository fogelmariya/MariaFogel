package hw7;

import base.InitTest;
import entities.User;
import org.testng.annotations.Test;

import static entities.MetalsColorsData.DEFAULT_DATA;
import static enums.HeaderMenuItems.METALS_COLORS;
import static site.JdiSite.*;

public class MetalsColorsPageTest extends InitTest {

    @Test
    public void metalsColorsDefaultTest() {
        //1 Login on JDI site as User
        homePage.open();

        // TODO I dont catch the idea...
        // TODO You have two thins - User.class and Users.enum. Is that reasonable ?
        // enum for hw4
        login(User.PETER);
        homePage.checkOpened();

        // TODO take a look on class work please, it will be better approach
        //2 Open Metals & Colors page by Header menu
        homePage.headerMenu.selects(METALS_COLORS);
        metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        // TODO Could you please use exactly the same approach that we're using with User ? x2`
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(DEFAULT_DATA);

        //4 Submit form Metals & Colors
        metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data  below:
        metalsColorsPage.metalsColorsResultSection.checkResult(DEFAULT_DATA);

    }
}

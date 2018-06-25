package hw7;

import base.InitTest;
import entities.MetalsColorsData;
import entities.User;
import enums.HeaderMenuItems;
import org.testng.annotations.Test;

import static site.JdiSite.*;

public class MetalsColorsPageTest extends InitTest {

    @Test
    public void metalsColorsDefaultTest() {
        //1 Login on JDI site as User
        homePage.open();

        // TODO I dont catch the idea...
        // TODO You have two thins - User.class and Users.enum. Is that reasonable ?
        login(User.PETER);
        homePage.checkOpened();

        // TODO take a look on class work please, it will be better approach
        //2 Open Metals & Colors page by Header menu
        openPage(HeaderMenuItems.METALS_COLORS.item);
        metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        // TODO Could you please use exactly the same approach that we're using with User ? x2`
        MetalsColorsData metalsColorsData = new MetalsColorsData();
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);

        //4 Submit form Metals & Colors
        metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data  below:
        metalsColorsPage.metalsColorsResultSection.checkResult(metalsColorsData);

    }
}

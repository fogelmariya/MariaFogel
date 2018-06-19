package hw7;

import base.InitTest;
import entities.MetalsColorsData;
import entities.User;
import enums.HeaderMenuItems;
import org.testng.annotations.Test;

import static site.JdiSite.*;


// TODO are you tricking me ? Where is .gitignore file ?
public class MetalsColorsPageTest extends InitTest {

    @Test
    public void metalsColorsDefaultTest() {
        //1 Login on JDI site as User
        homePage.open();
        // TODO what is the reason of new instance creation ?? Is Users.PITER_CHAILOVSKII not enough ?
        login(new User());
        homePage.checkOpened();

        // TODO What would you do in case if you should open all of the pages ?
        // TODO Wrote certain method for each of them ?
        // TODO it will be better to write only ONE parametrised method for open whatever page we want
        //2 Open Metals & Colors page by Header menu
        openPage(HeaderMenuItems.METALS_COLORS.item);
        metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        // TODO Could you please use exactly the same approach that we're using with User ?
        MetalsColorsData metalsColorsData = new MetalsColorsData();
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);

        //4 Submit form Metals & Colors
        metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data  below:
        metalsColorsPage.metalsColorsResultSection.checkResult(metalsColorsData);

    }
}

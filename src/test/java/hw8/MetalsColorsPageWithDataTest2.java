package hw8;

import base.TestInit;
import entities.MetalsColorsData;
import entities.User;
import enums.DatasEnum;
import enums.HeaderMenuItems;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import site.JdiSite2;
import utils.JsonLoader;

import java.io.FileNotFoundException;

import static site.JdiSite2.*;


public class MetalsColorsPageWithDataTest2 extends TestInit {

    @BeforeMethod
    public void openHomePage() {
        //1 Login on JDI site as User
        JdiSite2.open();
        login(User.PETER);

        //2 Open Metals & Colors page by Header menu
        openPage(HeaderMenuItems.METALS_COLORS.item);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
         logout();
    }

    @DataProvider
    public Object[] jsonData() throws FileNotFoundException {
        // TODO the last data set has been deleted, actually
        // TODO Why don't you use constant or enum or smth else ?
        return JsonLoader.getData(DatasEnum.METALS_COLORS_JSON.text);
    }

    @Test(dataProvider = "jsonData")
    public void jsonDataMetalsColorsTest(MetalsColorsData metalsColorsData) {

        //3
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);

        //4 Submit form Metals & Colors
        metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data  below:
        metalsColorsPage.metalsColorsResultSection.checkResult(metalsColorsData);
    }
}

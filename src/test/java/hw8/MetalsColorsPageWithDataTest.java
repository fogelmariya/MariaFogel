package hw8;

import base.TestInit;
import entities.MetalsColorsData;
import entities.User;
import enums.HeaderMenuItems;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JavaPropertyLoader;
import utils.JsonLoader;

import java.io.FileNotFoundException;

import static site.JdiSite.*;



public class MetalsColorsPageWithDataTest extends TestInit {

    private JavaPropertyLoader javaPropertyLoader = new JavaPropertyLoader();
    private String url = javaPropertyLoader.getProperty("site.url");


    @BeforeClass
    public void openHomePage() {
        //1 Login on JDI site as User
            homePage.open();
            login(User.PETER);
            homePage.checkOpened();
    }

    @AfterClass
    public void tearDown() {
        // logout();
    }

    @DataProvider
    public Object[] jsonData() throws FileNotFoundException {
        return JsonLoader.getData("src/main/resources/JDI_ex8_metalsColorsDataSet.json");
    }

    @Test(dataProvider = "jsonData")
    public void jsonDataMetalsColorsTest(MetalsColorsData metalsColorsData) {

        //2 Open Metals & Colors page by Header menu
        openPage(HeaderMenuItems.METALS_COLORS.item);
        metalsColorsPage.checkOpened();

        //3
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);

        //4 Submit form Metals & Colors
        metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data  below:
        metalsColorsPage.metalsColorsResultSection.checkResult(metalsColorsData);
    }
}

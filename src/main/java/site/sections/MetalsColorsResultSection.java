package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import entities.MetalsColorsData;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

import java.util.List;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class MetalsColorsResultSection extends Section {

    MetalsColorsData metalsColorsData; // TODO ???

    @FindBy(css = ".results li")
    private TextList actualResultLog;

    @Step
    public void checkResult(MetalsColorsData metalsColorsData) {
        List<String> actualResults = actualResultLog.getTextList();
        List<String> expectedResults = metalsColorsData.dataToListString();

        logger.info(expectedResults.toString());
        logger.info(actualResults.toString());

        for (String string : expectedResults) {
            Assert.assertTrue(actualResults.contains(string));
        }
    }
}

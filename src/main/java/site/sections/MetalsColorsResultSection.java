package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import entities.MetalsColorsData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class MetalsColorsResultSection extends Section {

    MetalsColorsData metalsColorsData;

    @FindBy(css = ".results li")
    private TextList actualResultLog;

    @Step
    public void checkResult(MetalsColorsData metalsColorsData) {
        List<String> logList = actualResultLog.getTextList();
        List<String> data = metalsColorsData.dataToListString();

        // TODO In case of JDI, it will be better with log4j
        logger.info(data.toString());
        logger.info(logList.toString());
        // !TODO
        for (String string : data) {
            Assert.assertTrue(logList.contains(string));
        }
    }
}

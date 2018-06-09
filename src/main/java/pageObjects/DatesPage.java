package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    @FindBy(css = ".ui-slider-handle")
    private List<SelenideElement> nodes;


    private SelenideElement sliderLeft;
    private SelenideElement sliderRight;

    @Step
    public void setSliderRange(int left, int right) {
        sliderLeft = nodes.get(0);
        sliderRight = nodes.get(1);

        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", sliderLeft);
        actions().dragAndDropBy(sliderLeft, -300, 0).build().perform();
        actions().dragAndDropBy(sliderRight, 300, 0).build().perform();

        double scrollPanelLength = sliderRight.getLocation().getX() - sliderLeft.getLocation().getX();
        double step = scrollPanelLength / 100;

        System.out.println(step);

        if (left > 0) {
            actions().dragAndDropBy(sliderLeft, (int) (step * left ), 0).build().perform();
        }
        if (right < 100) {
            actions().dragAndDropBy(sliderRight, (int) ((right - 100) * step - step), 0).build().perform();
        }

        sliderLeft.shouldHave(Condition.matchText(Integer.toString(left)));
        sliderRight.shouldHave(text(String.valueOf(right)));
    }

    @Step
    public void checkLog(int left, int right) {
        boolean exist1 = false;
        boolean exist2 = false;
        ElementsCollection logs = $$(".logs > li");
        System.out.println(logs.texts());
        for (SelenideElement log: logs) {
            if (log.getText().contains("Range 2(To):" + right + " link clicked"))
                exist1 = true;
            if (log.getText().contains("Range 2(From):" + left + " link clicked"))
                exist2 = true;
        }
        Assert.assertTrue(exist1);
        Assert.assertTrue(exist2);
    }
}

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repor}")
    public void searchRepository(String repor){
        $(".search-input").click();
        $("#query-builder-test").setValue(repor).pressEnter();
    }
    @Step("Кликаем по ссылке репозитория {nameRepor}")
    public void clickOnRepositoryLink(){
        $("[href ='/DimaKarpuk/demoqa-tests-23']").click();
    }
    @Step("Открываем таб issues")
    public void openIssuesTab(){
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие issues с номером {issue}")
    public void shouldSeeIssueWithNumber (int issue){
        $(".opened-by").shouldHave(text("#" + issue));
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

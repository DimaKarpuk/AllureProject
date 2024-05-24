import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepTest {
    private static final String REPOSITORY = "/DimaKarpuk";
    //private static final String NameREPOSITORY = " demoqa-tests-23";
    private static final int ISSUES = 1;
    @BeforeAll
    static void beforeAll(){
   //     Configuration.holdBrowserOpen= true;
    }
    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {open("https://github.com/");});
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория ", () -> {
            $("[href ='/DimaKarpuk/demoqa-tests-23']").click();
        });
        step("Открываем таб issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие issues с номером " + ISSUES, () -> {
            $(".opened-by").shouldHave(text(" #" + ISSUES));
        });
    }
    @Test
    public void testWebAnnotationTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.searchRepository(REPOSITORY);
        webSteps.clickOnRepositoryLink();
        webSteps.openIssuesTab();
        webSteps.shouldSeeIssueWithNumber(ISSUES);
    }
}


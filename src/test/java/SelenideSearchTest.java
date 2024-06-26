
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSearchTest {
    @BeforeAll
    static void beforeAll(){
   //     Configuration.holdBrowserOpen= true;
    }
    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("/DimaKarpuk").pressEnter();
        $("[href = '/DimaKarpuk/demoqa-tests-23']").click();
        $("#issues-tab").click();
        $(".opened-by").shouldHave(text(" #1 opened"));
    }
}


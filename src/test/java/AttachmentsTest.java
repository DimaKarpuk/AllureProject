import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.source;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {
        private static final String REPOSITORY = "/DimaKarpuk";
        //private static final String NameREPOSITORY = " demoqa-tests-23";
        private static final int ISSUES = 1;
        @BeforeAll
        static void beforeAll(){
            //     Configuration.holdBrowserOpen= true;
        }
        @Test
        public void testLambdaAttachments(){
            SelenideLogger.addListener("allure", new AllureSelenide());
            step("Открываем главную страницу", () -> {open("https://github.com/");});
            attachment("Source", webdriver(). driver(). source());
        }
        @Test
        public void testWebAnnotationTAttachments(){
            SelenideLogger.addListener("allure", new AllureSelenide());
            WebSteps webSteps = new WebSteps();
            webSteps.openMainPage();
            webSteps.takeScreenshot();
        }

}


import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LabelsTest {

    @BeforeAll
    static void beforeAll(){
   //     Configuration.holdBrowserOpen= true;
    }
    @Test
    @Feature("Issue в ркпозитории")
    @Story("Создание Issue")
    @Owner("DimaKarpuk")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "testing", url = "https://testing.github.com/")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void staticLabels(){

    }
    @Test
    public void dynamicLabels(){
        Allure.feature("Issue в ркпозитории");
        Allure.story("Создание Issue");
        Allure.label("Owner","DimaKarpuk");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.label("Testing", "https://testing.github.com/");

    }
}


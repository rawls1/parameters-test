package test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;





public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("baseUrl","https://demoqa.com");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.remote = System.getProperty("selenoidUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

}

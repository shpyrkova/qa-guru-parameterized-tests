package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class SwagLabTestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @BeforeEach
    void beforeEach() {
        open("/");
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }



}

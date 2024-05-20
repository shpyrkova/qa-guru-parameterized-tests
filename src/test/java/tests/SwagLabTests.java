package tests;

import data.ErrorUser;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SwagLabTests extends SwagLabTestBase {

    @CsvFileSource(resources = "/testdata/swagLabCredentials.csv")
    @ParameterizedTest(name = "После авторизации юзер {0} видит заголовок списка продуктов")
    @Tag("BLOCKER")
    void successfulAuthorizationTest(String login, String password) {
        $("#user-name").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();
        $("[data-test=title]").shouldHave(text("Products"));
    }

    static Stream<Arguments> errorUsersSeeCorrectMessages() {
        return Stream.of(
                Arguments.of(
                        ErrorUser.LOCKED,
                        "Epic sadface: Sorry, this user has been locked out.")
                        ,
                Arguments.of(
                        ErrorUser.INVALID,
                        "Epic sadface: Username and password do not match any user in this service")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "При попытке авторизации {0} юзер видит корректное сообщение об ошибке")
    @Tag("MAJOR")
    void errorUsersSeeCorrectMessages(ErrorUser user, String message) {
        $("#user-name").setValue(user.login);
        $("#password").setValue(user.password);
        $("#login-button").click();
        $("[data-test=error]").shouldHave(text(message));
    }

}
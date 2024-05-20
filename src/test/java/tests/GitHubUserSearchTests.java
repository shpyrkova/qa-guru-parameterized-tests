package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GitHubUserSearchTests extends GitHubUserSearchTestBase {

    @ValueSource(strings = {
            "shpyrkova", "surkovdennis"
    })
    @ParameterizedTest(name = "При поиске пользователя {0} выводятся блоки о пользователе и его фолловерах")
    void userInfoAndFollowersShouldExist(String username) {
        $("[placeholder='enter github user name']").setValue(username).pressEnter();
        $(".bio").shouldBe(visible);
        $(".followers").shouldBe(visible);
    }

}

package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitSelenideWikiTest {
//    Разработайте следующий автотест:
//    - Откройте страницу Selenide в Github
//    - Перейдите в раздел Wiki проекта
//    - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//    - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

    @Test
    void shouldFindJUnit5ExampleInSoftAssertions() {
        Configuration.browserSize = "1920x1080";
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $$(".UnderlineNav-body li").find(text("Wiki")).click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".wiki-more-pages-link button").click();
        $("div.js-wiki-sidebar-toggle-display ul").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions
        $$("div.js-wiki-sidebar-toggle-display ul li").find(text("SoftAssertions")).click();
        //проверьте что внутри есть пример кода для JUnit5
        $$("#wiki-content ol").find(text("Using JUnit5 extend test class")).shouldBe(visible);
        $$("#wiki-content ol").find(text("Using JUnit5 extend test class")).sibling(0).shouldHave(text("@ExtendWith"));
    }
}

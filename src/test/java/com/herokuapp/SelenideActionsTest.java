package com.herokuapp;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideActionsTest {
//Запрограммируйте Drag&Drop с помощью Selenide.actions()
//  - Откройте https://the-internet.herokuapp.com/drag_and_drop
//  - Перенесите прямоугольник А на место В
//  - Проверьте, что прямоугольники действительно поменялись
    @Test
    void dragAndDropTest(){
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}

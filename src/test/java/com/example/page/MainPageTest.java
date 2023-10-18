package com.example.page;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    @DisplayName("")
    @Test
    public void render() {
        //given
        MainPage mainPage = new MainPage()
                .subPage("c1",
                        new ProductsPage("hello", "test"),
                        new ProductsPage("hello", "test")
                )
                .subPage("c2",
                        new ProductsPage("test", "hello"),
                        new ProductsPage("cat", "cat")
                );
        //when
        var page = mainPage.render();
        //then
        System.out.println(page);
        assertTrue(page.contains("[ c1 MENU ]\n" +
                                 "1. hello      | test\n" +
                                 "2. hello      | test\n" +
                                 "\n" +
                                 "[ c2 MENU ]\n" +
                                 "3. test       | hello\n" +
                                 "4. cat        | cat"));
    }
}

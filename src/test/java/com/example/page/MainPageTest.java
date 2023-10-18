package com.example.page;

import com.example.response.MenuDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    @DisplayName("")
    @Test
    public void render() {
        //given
        MainPage mainPage = new MainPage()
                .subMenu("c1",
                        new MenuDto("hello", "test"),
                        new MenuDto("hello", "test")
                )
                .subMenu("c2",
                        new MenuDto("test", "hello"),
                        new MenuDto("cat", "cat")
                );
        //when
        var page = mainPage.render();
        //then
        System.out.println(page);
        assertTrue(page.contains("[ c1 MENU ]\n" +
                                 "1. test       | hello\n" +
                                 "2. test       | hello\n" +
                                 "\n" +
                                 "[ c2 MENU ]\n" +
                                 "3. hello      | test\n" +
                                 "4. cat        | cat"));
    }
}

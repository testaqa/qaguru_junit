package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.exist;

public class AppTests extends BaseTest{

    @Test
    @DisplayName("Menu sections presented")
    void MenuSectionsPresented() {
        homePage.menuSections.shouldHaveSize(6);
    }

    @Test
    @DisplayName("Search field exists")
    void SearchFieldExists() {
        homePage.searchField.should(exist);
    }

    @Test
    void StepsInPage() {
        homePage.VerifySearchFieldExists();
        homePage.VerifyMenuSectionsCount(6);
    }

    @ValueSource(strings = {"hello", "world"})
    @ParameterizedTest
    void SearchWithParametrizedStrings(String searchValue) {
        homePage.searchField.setValue(searchValue);
    }

    @CsvSource(value = {
            "hello, 111",
            "world, 222"
    })
    @ParameterizedTest
    void SearchWithCsv(String word1, int word2) {
        homePage.searchField.setValue(word1);
        homePage.searchField.setValue(String.valueOf(word2));
    }
}

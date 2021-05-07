package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchData;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.exist;

public class AppTests extends BaseTest {

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

    @MethodSource // if Stream<Arguments> method has other name, we need specify it here;
    @ParameterizedTest
    void SearchWithMethodSource(SearchData searchData, String moreData) {
        homePage.searchField.setValue(searchData.getWord1());
        homePage.searchField.sendKeys(String.valueOf(searchData.getWord2()));
        homePage.searchField.sendKeys(String.valueOf(moreData));
        Selenide.sleep(2000);
    }

    static Stream<Arguments> SearchWithMethodSource() {
        SearchData a =  new SearchData(); a.setWord1("hello"); a.setWord2(111);
        SearchData b =  new SearchData(); b.setWord1("world"); b.setWord2(222);

        return Stream.of(
                Arguments.of(a, "---"),
                Arguments.of(b, "^^^")
        );
    }
}

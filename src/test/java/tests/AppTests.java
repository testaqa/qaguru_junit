package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}

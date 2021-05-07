package tests;

import helpers.DriverHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    HomePage homePage = new HomePage();

    @BeforeAll
    public static void BeforeAll() {
        DriverHelper.configureDriver();
    }

    @BeforeEach
    public void BeforeEach() {
        open("");
        HomePage homePage = new HomePage();
        if (homePage.citySelection.size() > 0) {
            homePage.citySelection.first().click();
        }
    }
}

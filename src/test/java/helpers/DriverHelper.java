package helpers;

import com.codeborne.selenide.Configuration;

public class DriverHelper {

    public static void configureDriver() {
        Configuration.baseUrl = "https://godzila.bg/en";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.startMaximized = true;
    }

}

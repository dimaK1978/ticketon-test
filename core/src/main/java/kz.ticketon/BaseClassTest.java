package kz.ticketon;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClassTest {

    protected static int TIME_OUT = 10000;

    @BeforeAll
    public static void setUppAll() {
        Configuration.browserSize = "1280x800";
      //  Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = TIME_OUT;
        Configuration.browserCapabilities =
                new ChromeOptions().addArguments("--remote-allow-origins=*");
    }
}
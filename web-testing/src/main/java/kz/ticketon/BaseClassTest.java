package kz.ticketon;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class BaseClassTest {
    protected static String BASIC_URL = "htpps://ticeton.kz";
    protected static int TIME_OUT = 10000;


   @BeforeAll
    public static void setUppAll() {
       Configuration.browserSize = "1280x800";
       Configuration.pageLoadStrategy = "normal";
       Configuration.timeout = TIME_OUT;
       // Configuration.browserCapabilities = new ChromeOptions().addArguments()
    }

    public void openStartPage() {
        open(BASIC_URL);
    }
}
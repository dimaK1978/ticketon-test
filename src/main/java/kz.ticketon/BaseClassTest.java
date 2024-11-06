package kz.ticketon;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

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
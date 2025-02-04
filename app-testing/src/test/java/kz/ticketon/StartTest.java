package kz.ticketon;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.appium.SelenideAppium.$x;

public class StartTest extends BaseClassAppTest{


    @Test
    public void startTicketon() {
      //SelenideElement  $x("com.google.android.apps.nexuslauncher:id/overview_actions_view");
      $x("//android.widget.TextView[@content-desc='Predicted app: Ticketon']").click();
    }
}

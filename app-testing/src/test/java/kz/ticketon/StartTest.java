package kz.ticketon;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class StartTest extends BaseClassAppTest{
    @Test
    public void startTicketon(){
        $x("//android.widget.TextView[@content-desc=\"Ticketon\"]").click();
    }
}

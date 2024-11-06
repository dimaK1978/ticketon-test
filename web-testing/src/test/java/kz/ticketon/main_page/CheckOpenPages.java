package kz.ticketon.main_page;

import kz.ticketon.BaseClassWebTest;
import org.junit.jupiter.api.Test;

public class CheckOpenPages extends BaseClassWebTest {
    @Test
    public void checkStartRus(){
        openStartPageRus();
    }

    @Test
    public void checkStartKz(){
        openStartPageKz();
    }

    @Test
    public void checkStartEng(){
        openStartPageEng();
    }
}

package kz.ticketon.pages.museums;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.MakingOrderOldFormPage;
import kz.ticketon.pages.MakingOrderPage;
import kz.ticketon.pages.SessionPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class SessionMuseumOldFormPage extends SessionPage {

    private SelenideElement fullDataSession = $x("//div[@class='timeAndPlace']");
    private ElementsCollection ticketsWithoutPlace = $$x("//div[@class='ticketWrapper entryTicketComponent']");
    private SelenideElement addTicketButton = $x("//button[@class='button secondary addTicketButton']");

    @Override
    public String getFullDataSessionActual() {
        return fullDataSession.getText();
    }

    @Override
    public int getTicketQantiti() {
        return ticketsWithoutPlace.size();
    }

    @Override
    public void deleteTicket() {
        if (ticketsWithoutPlace.size() == 0) {
            throw new RuntimeException("Билетов с списке нет");
        }
        ticketsWithoutPlace.get(0).$("img[alt='close']").click();
        plaseInd--;
    }

    public SessionMuseumOldFormPage(String titleExpect, String time, String day, String month, String movieTheatre) {
        super(titleExpect, time, day, month, movieTheatre);
        titleActual = $x("//div[@class='title']");
        makingOrderButtom = $x("//button[@class='button primary']");
    }

    @Override
    public void clickSeatAddTicket() {
        SleepUtils.sleepSeconds(5);
        if (addTicketButton.exists()) {
            tickeForm = TickeForm.WITHOUT_PLACE;
            if (ticketsWithoutPlace.size() == plaseInd) {
                addTicketButton.click();
            }
            plaseInd++;
        }
    }

    @Override
    @Step("переход к оформлению заказа")
    public MakingOrderPage makingOrder(){
        makingOrderButtom.click();
        return new MakingOrderOldFormPage();
    }
}

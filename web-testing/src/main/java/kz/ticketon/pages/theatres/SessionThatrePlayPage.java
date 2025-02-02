package kz.ticketon.pages.theatres;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.MakingOrderOldFormPage;
import kz.ticketon.pages.MakingOrderPage;
import kz.ticketon.pages.SessionPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class SessionThatrePlayPage extends SessionPage {
    private SelenideElement freeSeatButton = $x("//div[@style='color: rgb(255, 255, 255);']");
    private SelenideElement fullDataSession = $x("//div[@class='timeAndPlace']");
    private ElementsCollection tickets = $$x("//div[@class='ticketWrapper desktopTicket']");
    private SelenideElement sectorOfHall = $("path[stroke='#00bbff']");

    @Override
    public String getFullDataSessionActual() {
        return fullDataSession.getText();
    }

    @Override
    public int getTicketQantiti() {
        return tickets.size();
    }

    @Override
    public void deleteTicket() {
        if (tickets.size() == 0) {
            throw new RuntimeException("Билетов с списке нет");
        }
        tickets.get(0).$("img[alt='закрыть']").click();
    }

    public SessionThatrePlayPage(String titleExpect, String time, String day, String month, String movieTheatre) {
        super(titleExpect, time, day, month, movieTheatre);
        titleActual = $x("//div[@class='title']");
        makingOrderButtom = $x("//button[@class='button primary']");
    }

    @Override
    public void clickSeatAddTicket() {
        if (sectorOfHall.exists()) {
            sectorOfHall.click();
            SleepUtils.sleepSeconds(6);
        }

        if (!freeSeatButton.exists()) {
            throw new RuntimeException("Свободных мест нет");
        }
        freeSeatButton.click();
    }

    @Override
    @Step("переход к оформлению заказа")
    public MakingOrderPage makingOrder(){
        makingOrderButtom.click();
        return new MakingOrderOldFormPage();
    }
}

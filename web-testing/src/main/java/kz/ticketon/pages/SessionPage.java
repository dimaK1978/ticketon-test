package kz.ticketon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public abstract class SessionPage {
    protected final String titleExpect;
    protected final String time;
    protected final String day;
    protected final String month;
    protected final String eventLocation;
    protected List<String> seats;
    //элемент содержащий заголовке формы с названием события
    protected SelenideElement titleActual;

   protected TickeForm tickeForm = TickeForm.WITH_PLACE;
   protected int plaseInd = 0;

    public SessionPage(String titleExpect, String time, String day, String month, String eventLocation) {
        this.titleExpect = titleExpect;
        this.time = time;
        this.day = day;
        this.month = month;
        this.eventLocation = eventLocation;
        seats = new ArrayList<>();
    }

    @Step("Клик на свободное место в зале - добавление билета")
    public abstract void clickSeatAddTicket();

    @Step("Удаление выбранного билета")
    public abstract void deleteTicket();

    @Step("Получение текста актуального заголовка открывшейся формы с названием события")
    public String getTitleActual() {
        return titleActual.getText();
    }

    @Step("Получение ожидаемого текста заголовка с названием события")
    public String getTitleExpect() {
        return titleExpect;
    }

    @Step("Получение ожидаемого текста данных о сеансе с временем, датой и местом проведения")
    public String getFullDataSessionExpect() {
        return String.format("%s %s в %s, %s", day, month, time, eventLocation);
    }

    @Step("Получение текста данных о сеансе с временем, датой и местом проведения из открывшейся формы")
    public abstract String getFullDataSessionActual();

    @Step("Получение количества выбранных билетов")
    public abstract int getTicketQantiti();

    protected enum TickeForm {
        WITH_PLACE,
        WITHOUT_PLACE;
    }
}

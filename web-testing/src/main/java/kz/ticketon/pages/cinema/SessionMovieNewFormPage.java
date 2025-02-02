package kz.ticketon.pages.cinema;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.pages.MakingOrderNewFormPage;
import kz.ticketon.pages.MakingOrderOldFormPage;
import kz.ticketon.pages.MakingOrderPage;
import kz.ticketon.pages.SessionPage;

import static com.codeborne.selenide.Selenide.*;

public class SessionMovieNewFormPage extends SessionPage {

    //элемент содержащий название кинотеатра
    protected SelenideElement movieTheatreActual = $x("//div[@class='s-i-in']");
    //элемент содержащий дату сеанса
    protected SelenideElement dateActual = $x("//div[@id='s-show']");
    private SelenideElement tickets = $x("//div[@id='s-seats']");

    private ElementsCollection freeSeatButtons = $$x("//i[@class='mask ']");
    private int plaseInd = 0;

    @Step("Клик на свободное место в зале - добавление билета")
    @Override
    public void clickSeatAddTicket() {
        if (freeSeatButtons.isEmpty() || plaseInd >= freeSeatButtons.size()) {
            throw new RuntimeException("Свободных мест нет");
        }
        freeSeatButtons.get(plaseInd).click();
        plaseInd++;
    }

    @Step("Удаление выбранного билета")
    @Override
    public void deleteTicket() {
        plaseInd--;
        freeSeatButtons.get(plaseInd).click();
    }

    @Step("Получение текста данных о сеансе с временем, датой и местом проведения из открывшейся формы")
    @Override
    public String getFullDataSessionActual() {
        return String.format(
                "%s, %s", dateActual.getText(),
                movieTheatreActual.getOwnText());
    }

    @Step("Получение количества выбранных билетов")
    @Override
    public int getTicketQantiti() {
        if (!tickets.exists()) {
            return 0;
        }
        return Integer.parseInt(tickets.getOwnText().split(" ")[0]);
    }

    public SessionMovieNewFormPage(String titleExpect, String time, String day, String month, String movieTheatre) {
        super(titleExpect, time, day, month, movieTheatre);
        titleActual = $x("//div[@id='s-event']");
        makingOrderButtom = $x("//a[@class='next']");
    }

    @Override
    @Step("переход к оформлению заказа")
    public MakingOrderPage makingOrder() {
        makingOrderButtom.click();
        return new MakingOrderNewFormPage();
    }
}

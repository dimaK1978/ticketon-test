package kz.ticketon.pages.museums;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.MakingOrderNewFormPage;
import kz.ticketon.pages.MakingOrderOldFormPage;
import kz.ticketon.pages.MakingOrderPage;
import kz.ticketon.pages.SessionPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SessionMuseumNewFormPage extends SessionPage {

    private SelenideElement fullDataSession = $x("//div[@class='timeAndPlace']");
    private ElementsCollection ticketsWithoutPlace = $$x("//tr[@class='row--item']");
    private SelenideElement addTicketButton = $x("//button[@class='tickets--add-btn btn']");

    protected SelenideElement museumActual =  $x("//div[@class='s-i-in']");
    //элемент содержащий дату сеанса
    protected SelenideElement dateActual = $x("//div[@id='s-show']");

    @Override
    public int getTicketQantiti() {
        return ticketsWithoutPlace.size();
    }

    @Override
    public void deleteTicket() {
        if (ticketsWithoutPlace.size() == 0) {
            throw new RuntimeException("Билетов с списке нет");
        }
        ticketsWithoutPlace.get(0).$("td[class='row--remove']").click();
        plaseInd--;
    }
    public SessionMuseumNewFormPage(String titleExpect, String time, String day, String month, String movieTheatre) {
        super(titleExpect, time, day, month, movieTheatre);
        titleActual = $x("//div[@id='s-event']");
        makingOrderButtom = $x("//a[@id='next']");
    }


    @Override
    public String getFullDataSessionActual() {
        return String.format(
                "%s, %s", dateActual.getText(),
                museumActual.getOwnText());
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
        return new MakingOrderNewFormPage();
    }
}

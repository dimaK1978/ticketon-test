package kz.ticketon.pages.cinema;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.BaseTemlatePage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class EventPageCinema extends BaseTemlatePage {

    private String title;
    final ElementsCollection availableSessions = $$x("//div[@class='ScheduleRow_scheduleRow__o3xf2']");
    final SelenideElement titleEvent = $x("//h1");

    private SelenideElement frameNewFormChoosePlase = $("[id='frame_ticketonWidgetContainer']");
    private SelenideElement frameOldFormChoosePlase = $("[id='widgetFrame']");

    public EventPageCinema(final Cities city, final Languages language, final String title) {
        super(city, language);
        this.title = title;
    }

    public SessionMoviePage getFirstSessionMovie() {
        return getSessionMovie(availableSessions.first());
    }

    @Step("Выбор доступного сеанса, переход к форме выбора мест и приобретения билетов")
    public SessionMoviePage getSessionMovie(SelenideElement selenideElement) {
        if (availableSessions.size() == 0) {
            throw new RuntimeException("Нет доступных сеансов");
        }
        final SelenideElement buttonSession = selenideElement.find("span[class='TicketButton_text__HwCFn']");
        final String time = buttonSession.getOwnText();
        final String day = selenideElement.find("div[class='Date_day__GAPLg']").getText();
        final String month = selenideElement.find("div[class='Date_dateText__h6416']").$(new By.ByTagName("div")).getText();
        final String movieTheatre = selenideElement.find("div[class='CinemaInfo_cinemaName___Escv']").getText();
        final String adres = selenideElement.find("div[class='CinemaInfo_address__jpAG6']").getText();
        buttonSession.scrollTo().click();
        try {
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /*
        На сайте одноврменно используются две разные формы выбора мест и преобретения билетов. Какая из форм
        будет использована в каждом конкретном случае заранее по этой причине приходится проверять по факту
        */
        if (frameNewFormChoosePlase.exists()) {
            switchTo().frame(frameNewFormChoosePlase);
            return new SessionMovieNewFormPage(title, time, day, month, movieTheatre, adres);
        } else if (frameOldFormChoosePlase.exists()) {
            switchTo().frame(frameOldFormChoosePlase);
            return new SessionMovieOldFormPage(title, time, day, month, movieTheatre, adres);
        } else {
            throw new RuntimeException("Форма для выбора мест в кинотеатре не загрузилась");
        }
    }

    @Step("Получение атуального названия фильма")
    public String getTitleActual() {
        return titleEvent.getText();
    }

    @Step
    public String getTitleExpect() {
        return title;
    }

}

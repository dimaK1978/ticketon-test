package kz.ticketon.pages.cinema;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SessionMovieNewFormPage extends SessionMoviePage {


    private ElementsCollection tickets = $$x("//div[@class='ticketWrapper desktopTicket']");


   // <div class="s-i-in" id="s-place">Chaplin MEGA Center (ул. Розыбакиева)<em>г. Алматы, ул. Розыбакиева 247а</em></div>


    public SessionMovieNewFormPage(String titleExpect, String time, String day, String month, String movieTheatre, String adres) {
        super(titleExpect, time, day, month, movieTheatre, adres );
        freeSeatButton = $("i[class='mask ']");
        titleActual = $x("//div[@id='s-event']");
        movieTheatreActual = $("div[class='s-i-in']");
        dateActual = $x("//div[@id='s-show']");
    }
}

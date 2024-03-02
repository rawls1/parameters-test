package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class CalendarComponent {
    private final SelenideElement chooseYear = $(".react-datepicker__year-select");
    private final SelenideElement chooseMonth = $(".react-datepicker__month-select");
    private final SelenideElement chooseDay = $(".react-datepicker__month:not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year) {
        chooseMonth.$(byText(month)).click();
        chooseYear.selectOption(year);
        chooseDay.$(byText(day)).click();
    }
}

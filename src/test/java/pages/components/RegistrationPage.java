package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress "),
            selectStateInput = $("#react-select-3-input"),
            selectCityInput = $("#react-select-4-input"),
            submitInput = $("#submit"),
            tableResponsive = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('.fc-cta-consent').click()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadFromClasspath(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setSelectState(String value) {
        selectStateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setSelectCity(String value) {
        selectCityInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationPage checkSubmitButtonBorderColor(String cssStyleName, String  color) {
        submitInput.shouldHave(cssValue(cssStyleName, color));
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
package test;

import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Owner;
import pages.components.RegistrationPage;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
@Owner("@rawls1")
@Link(url = "https://demoqa.com/automation-practice-form")
@DisplayName("Проверка заполнения всех полей формы и их отображение")
public class RegistrationWithPageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        step("Открываем страницу с формой", () -> {
            registrationPage.openPage();
        });
        step("Заполняем все поля формы", () -> {
            registrationPage.setFirstName("Olga")
                    .setLastName("Savina")
                    .setEmail("olga@savina.com")
                    .setGender("Female")
                    .setUserNumber("7777777777")
                    .setDateOfBirth("31", "October", "2023")
                    .setSubject("Maths")
                    .setHobbiesWrapper("Sports")
                    .setHobbiesWrapper("Reading")
                    .setHobbiesWrapper("Music")
                    .setUploadFromClasspath("Little-cat.jpg")
                    .setCurrentAddress("Luneburg, shtrasse 111")
                    .setSelectState("NCR")
                    .setSelectCity("Noida");
        });

        step("Отправляем форму регистрации", () -> {
            registrationPage.setSubmit();
        });

        step("Проверка результата регистрации", () -> {
            registrationPage.checkResult("Student Name", "Olga Savina")
                    .checkResult("Student Email", "olga@savina.com")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "7777777777")
                    .checkResult("Date of Birth", "31 October,2023")
                    .checkResult("Subjects", "Maths")
                    .checkResult("Hobbies", "Sports, Reading, Music")
                    .checkResult("Picture", "Little-cat.jpg")
                    .checkResult("Address", "Luneburg, shtrasse 111")
                    .checkResult("State and City", "NCR Noida");
        });
    }

    @Test
    @DisplayName("Проверка заполнения минимального количества полей формы регистрации")
    void minimumFieldsRegistrationTest() {
        step("Открываем страницу с формой", () -> {
            registrationPage.openPage();
        });

        step("Заполняем все обязательные поля формы регистрации", () -> {
            registrationPage.setFirstName("Olga")
                    .setLastName("Savina")
                    .setGender("Female")
                    .setUserNumber("7777777777")
                    .setDateOfBirth("31", "October", "2023");
        });

        step("Отправляем форму регистрации", () -> {
            registrationPage.setSubmit();
        });

        step("Проверка результата регистрации", () -> {
            registrationPage.checkResult("Student Name", "Olga Savina")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "7777777777")
                    .checkResult("Date of Birth", "31 October,2023");

        });
    }

    @Test
    @DisplayName("Проверка отправки незаполненной  формы регистрации")
    void negativRegistrationTest() {
        step("Открываем страницу с формой", () -> {
            registrationPage.openPage();
        });
        step("Отправляем пустую форму регистрации", () -> {
            registrationPage.setSubmit();
        });
        step("Проверка подсвечивания обязательных полей", () -> {

            registrationPage.checkSubmitButtonBorderColor("border-color", "rgb(0, 98, 204)");
        });
    }
  }


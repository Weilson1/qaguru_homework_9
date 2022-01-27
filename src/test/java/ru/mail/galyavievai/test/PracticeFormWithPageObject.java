package ru.mail.galyavievai.test;

import org.junit.jupiter.api.Test;
import ru.mail.galyavievai.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {
        registrationPage
                .openPage()
                .inputFirstName("John")
                .inputLastName("Shepard")
                .inputUserEmail("jshepard@email.net")
                .inputGenderMale()
                .inputUserNumber("8912345678")
                .calendarComponent.setDate("09", "2", "1994") // Месяцы начинаются с 0
                .inputSubject("Maths")
                .inputSubject("Economics")
                .inputHobbies("Sports")
                .inputHobbies("Reading")
                .uploadPicture("img/1.png")
                .inputAddress("My address is not a house and not the street, my address is the Soviet Union")
                .inputState("NCR")
                .inputCity("Delhi");
        $("#submit").click();

// Проверка теста
        $(byText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResult("John Shepard")
                .checkResult("jshepard@email.net")
                .checkResult("Male")
                .checkResult("8912345678")
                .checkResult("09 March,1994")
                .checkResult("Maths, Economics")
                .checkResult("Sports, Reading")
                .checkResult("1.png")
                .checkResult("My address is not a house and not the street, my address is the Soviet Union")
                .checkResult("NCR Delhi");
    }
}

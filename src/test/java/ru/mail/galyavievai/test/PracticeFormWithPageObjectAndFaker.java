package ru.mail.galyavievai.test;

import org.junit.jupiter.api.Test;
import ru.mail.galyavievai.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObjectAndFaker extends TestBase {
    TestDate testDate = new TestDate();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {
        registrationPage
                .openPage()
                .inputFirstName(testDate.randomFirstName)
                .inputLastName(testDate.randomLastName)
                .inputUserEmail(testDate.randomEmail)
                .inputGenderMale()
                .inputUserNumber(testDate.randomPhoneNumber)
                .calendarComponent.setDate("09", "2", "1994") // Месяцы начинаются с 0
                .inputSubject("Maths")
                .inputSubject("Economics")
                .inputHobbies("Sports")
                .inputHobbies("Reading")
                .uploadPicture("img/1.png")
                .inputAddress(testDate.randomAddress)
                .inputState("NCR")
                .inputCity("Delhi");
        $("#submit").click();

// Проверка теста
        $(byText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResult(testDate.randomFirstName + " " + testDate.randomLastName)
                .checkResult(testDate.randomEmail)
                .checkResult("Male")
                .checkResult(testDate.randomPhoneNumber)
                .checkResult("09 March,1994")
                .checkResult("Maths, Economics")
                .checkResult("Sports, Reading")
                .checkResult("1.png")
                .checkResult(testDate.randomAddress)
                .checkResult("NCR Delhi");
    }
}

package ru.mail.galyavievai;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Qaguru_homework_9 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void succesTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("John");
        $("#lastName").setValue("Shepard");
        $("#userEmail").setValue("jshepard@email.net");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__day--009:not(.react-datapicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(
                "My address is not a house and not the street, my address is the Soviet Union").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
// Проверка теста
        $(byText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("John Shepard"), text("jshepard@email.net"), text("Male"), text("1111111111"),
                text("09 March,1994"), text("Maths, Economics"), text("Sports"), text("1.png"),
                text("My address is not a house and not the street, my address is the Soviet Union"),
                text("NCR Delhi"));
    }
}

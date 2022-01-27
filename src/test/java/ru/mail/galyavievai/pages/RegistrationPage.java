package ru.mail.galyavievai.pages;

import com.codeborne.selenide.SelenideElement;
//import ru.mail.galyavievai.Test.TestDate;
import ru.mail.galyavievai.component.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
        SelenideElement
            firstNameType = $("#firstName"),
            lastNameType = $("#lastName"),
            userEmailType = $("#userEmail"),
            userNumberType = $("#userNumber"),
            subjectType = $("#subjectsInput"),
            hobbiesType = $("#hobbiesWrapper"),
            uploadPictureType = $("#uploadPicture"),
            addressType = $("#currentAddress"),
            stateType = $("#stateCity-wrapper"),
            cityType = $("#stateCity-wrapper"),
            resultTable = $(".table-responsive");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage inputFirstName(String value) {
        firstNameType.setValue(value);
        return this;
    }

    public RegistrationPage inputLastName(String value) {
        lastNameType.setValue(value);

        return this;
    }

    public RegistrationPage inputUserEmail(String value) {
        userEmailType.setValue(value);

        return this;
    }
    public RegistrationPage inputGenderMale() {
        $("[for=gender-radio-1]").click();

        return this;
    }
    public RegistrationPage inputGenderFemale() {
        $("[for=gender-radio-2]").click();

        return this;
    }
    public RegistrationPage inputGenderOther() {
        $("[for=gender-radio-3]").click();

        return this;
    }
    public RegistrationPage inputUserNumber(String value) {
        userNumberType.setValue(value);

        return this;
    }
    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage inputSubject(String value) {
        subjectType.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage inputHobbies(String value) {
        hobbiesType.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureType.uploadFromClasspath("img/1.png");

        return this;
    }
    public RegistrationPage inputAddress(String value) {
        addressType.setValue(value).scrollTo();

        return this;
    }
    public RegistrationPage inputState(String value) {
        $("#state").click();
        stateType.$(byText(value)).click();

        return this;
    }
    public RegistrationPage inputCity(String value) {
        $("#city").click();
        cityType.$(byText(value)).click();

        return this;
    }
    public RegistrationPage checkResult(String value){
        resultTable.shouldHave(text(value));

        return this;
}
}


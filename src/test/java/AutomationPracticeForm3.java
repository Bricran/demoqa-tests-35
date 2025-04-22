import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm3 {

    @BeforeAll
     static void BeforeAllTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void FillForm() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Angel");
        $("#lastName").setValue("Testova");
        $("#userEmail").setValue("test@mail.ru");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("9999999999");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2010");
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $$(".react-datepicker__day").findBy(text("10")).click();

        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("wp6044139.jpg");

        $("#currentAddress").setValue("деревня Парчим, 30, муниципальное образование Пажга, муниципальный район Сыктывдинский, Республика Коми, 168214");

        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").click();
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Angel Testova"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("test@mail.ru"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Other"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("9999999999"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("10 May,2010"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Biology"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("wp6044139.jpg"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("деревня Парчим, 30, муниципальное образование Пажга, муниципальный район Сыктывдинский, Республика Коми, 168214"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("Haryana Karnal"));

    }
}

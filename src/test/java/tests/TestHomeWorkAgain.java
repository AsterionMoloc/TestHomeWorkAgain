package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;
public class TestHomeWorkAgain {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    Faker faker=new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String mobile =getRandomPhone();
    String address=faker.address().fullAddress();
    String birthDay=String.valueOf(getRandomInt(1,31));
    String birthYear=String.valueOf(getRandomInt(1985,2005));
    // birthYear=String.valueOf(getRandomInt(1985,2005));

    @Test
    public void HomeWorkAgain(){
        //открыть форму регистрации
        open("https://demoqa.com/automation-practice-form");
        //установить данные для входа (имя, фамилия, email)
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        //выбрать пол
        $x("//label[contains(text(),'Male')]").click();

        //установить номер телефона
        $("#userNumber").val(mobile);

        //установить дату рождения
        $x("//input[@id='dateOfBirthInput']").click();
        if (birthDay.length() == 1) birthDay = "0" + birthDay;
        $x("//div/select[@class='react-datepicker__month-select']").selectOption("January");
        $x("//div/select[@class='react-datepicker__year-select']").selectOption(birthYear);
        //$x("//div[contains(@class,'react-datepicker__day--012')]").click();
        $x("//div[contains(@class,'react-datepicker__day--0" + birthDay + "')]").click();

        //$x("//select[@class='react-datepicker__year-select']").selectOption(dateOfBirthYear);
        //$x("//select[@class='react-datepicker__month-select']").selectOption(dateOfBirthMonth);


        //установить язык
        $x("//input[@id = 'subjectsInput']").val("Hin");
        $x("//*[text()='Hindi']").click();

        //выбрать хобби
        $x("//label[contains(text(),'Reading')]").click();

        //приложить изображение
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/Tst.jpg");

        //установить текущий адрес
        $x("//*[@id='currentAddress']").val(address);

        //выбрать штат
        $x("//div[@id='state']").scrollTo();
        $x("//div[@id='state']").click();
        $x("//*[text()='Haryana']").click();

        //выбрать город
        $x("//div[@id='city']").click();
        $x("//*[text()='Panipat']").click();

        //подтверждение
        $x("//*[@id='submit']").click();

        //проверка результата
        $x("//td[(text()='Student Name')]").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[(text()='Student Email')]").parent().shouldHave(text(email));
        $x("//td[(text()='Gender')]").parent().shouldHave(text("Male"));
        $x("//td[(text()='Mobile')]").parent().shouldHave(text(mobile));
        $x("//td[(text()='Date of Birth')]").parent().shouldHave(text(birthDay +" "+ "January" +","+ birthYear));
        $x("//td[(text()='Subjects')]").parent().shouldHave(text("Hindi"));
        $x("//td[(text()='Hobbies')]").parent().shouldHave(text("Reading"));
        $x("//td[(text()='Picture')]").parent().shouldHave(text("Tst.jpg"));
        $x("//td[(text()='Address')]").parent().shouldHave(text(address));
        $x("//td[(text()='State and City')]").parent().shouldHave(text("Haryana" +" " + "Panipat"));

        //закрыть окно с результатами
        $x("//*[@id='closeLargeModal']").click();


    }
}

package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestHomeWorkAgain {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
           String  birthYear="2000",
                   birthMonth="January",
                   birthDay="1";

    @Test
    public void HomeWorkAgain(){

        //открыть форму регистрации
        open("https://demoqa.com/automation-practice-form");

        //установить данные для входа (имя, фамилия, email)
        $("#firstName").setValue("zxc");
        $("#lastName").setValue("zxc");
        $("#userEmail").setValue("zxc@zxc.com");

        //выбрать пол
        $x("//label[contains(text(),'Male')]").click();

        //установить номер телефона
        $("#userNumber").setValue("1231231231");

        //устанвоить дату рождения
        $("#dateOfBirthInput").click();
        $x("//*[@class='react-datepicker__month-select']/option [1]").click();
        $x("//*[@class='react-datepicker__year-select']/option [101]").click();
        $x("//div[contains(@class,'react-datepicker__day--001')]").click();

        //установить язык
        $x("//input[@id = 'subjectsInput']").setValue("Hin");
        $x("//*[text()='Hindi']").click();

        //выбрать хобби
        $x("//label[contains(text(),'Reading')]").click();

        //приложить изображение
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/Tst.jpg");

        //установить текущий адрес
        $x("//*[@id='currentAddress']").setValue("zxczxc");

        //выбрать штат
        $x("//div[@id='state']").scrollTo();
        $x("//div[@id='state']").click();
        $x("//*[text()='Haryana']").click();

        //выбрать город
        $x("//div[@id='city']").scrollTo();
        $x("//div[@id='city']").click();
        $x("//*[text()='Panipat']").click();

        //подтверждение
        $x("//*[@id='submit']").click();

        //проверка результата
        $x("//td[(text()='Student Name')]").parent().shouldHave(text("zxc" + " " + "zxc"));
        $x("//td[(text()='Student Email')]").parent().shouldHave(text("zxc@zxc.com"));
        $x("//td[(text()='Gender')]").parent().shouldHave(text("Male"));
        $x("//td[(text()='Mobile')]").parent().shouldHave(text("1231231231"));
        $x("//td[(text()='Date of Birth')]").parent().shouldHave(text(birthDay + " " + birthMonth+ "," + birthYear));
        $x("//td[(text()='Subjects')]").parent().shouldHave(text("Hindi"));
        $x("//td[(text()='Hobbies')]").parent().shouldHave(text("Reading"));
        $x("//td[(text()='Picture')]").parent().shouldHave(text("Tst.jpg"));
        $x("//td[(text()='Address')]").parent().shouldHave(text("zxczxc"));
        $x("//td[(text()='State and City')]").parent().shouldHave(text("Haryana" + " " + "Panipat"));

        //закрыть окно с результатами
        $x("//*[@id='closeLargeModal']").click();


        sleep(5000);

    }
}

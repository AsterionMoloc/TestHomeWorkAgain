import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class TestHomeWorkAgain {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void HomeWorkAgain(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("zxc");
        $("#lastName").setValue("zxc");
        $("#userEmail").setValue("zxc@zxc.com");
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").setValue("1231231231");
        $("#dateOfBirthInput").click();
        $x("//*[@class='react-datepicker__month-select']/option [1]").click();
        $x("//*[@class='react-datepicker__year-select']/option [101]").click();
        $x("//*[@class='react-datepicker__day react-datepicker__day--001 react-datepicker__day--weekend']").click();
        $x("//input[@id = 'subjectsInput']").setValue("Hin");
        $x("//*[text()='Hindi']").click();
        $x("//label[contains(text(),'Reading')]").click();
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/Tst.jpg");
        $x("//*[@id='currentAddress']").setValue("zxczxc");
        $x("//*[@id='react-select-3-input']").setValue("Har");
        $x("//*[text()='Haryana']").click();
        $x("//*[@id='react-select-4-input']").setValue("Pan");
        $x("//*[text()='Panipat']").click();
        $x("//*[@id='submit']").click();
        $x("//*[@id='closeLargeModal']").click();

    }
}

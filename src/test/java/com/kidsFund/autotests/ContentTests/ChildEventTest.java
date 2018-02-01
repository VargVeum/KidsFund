package com.kidsFund.autotests.ContentTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class ChildEventTest extends BaseTest {

    //Create event
    private final By yourChildrenButton = By.xpath("//*[text()='Your Children']");
    private final By chooseChildAccount = By.xpath("//*[text()='Manny']");
    private final By homePageButton = By.xpath("//*[text()='Home Page']");
    private final String timePickers = "div.rc-time-picker-panel-select ul";
    private final String CreateAPostforThisEventCheckBox = "label.sc-gpHHfC.hkCaAS";
    private final String Submit = "button.sc-iomxrj.NMjfH";

    @Test
    public void userLogin() {
        loginViaEmail();

        $(yourChildrenButton).click();
        $(chooseChildAccount).click();
        $(homePageButton).click();
        fillInfoAboutEvent();
        chooseEventStartTime();
        chooseEventEndTime();
        chooseTimeZone();
        addAdditionalContactPerson();
        chooseCreatePostAboutEvent();
        submitCreateEvent();

        close();

    }

    private void fillInfoAboutEvent() {
        $(By.xpath("//*[text()='Add Event']")).shouldHave(Condition.text("Add Event")).click();
        $("#title").setValue("AUTO event 29.01");
        $("div.Select-control").click();
        $(By.xpath("//*[text()='Baptism']")).click();
        $$("div.Select-control").get(1).click();
        $(By.xpath("//*[text()='Party']")).click();
        $("#description").setValue("Test event");
        $("input[placeholder='Event Date *']").setValue("29-01-2018").sendKeys(Keys.ENTER);
    }

    private void submitCreateEvent() {
        $(Submit).click();
    }

    private void chooseCreatePostAboutEvent() {
        $$(CreateAPostforThisEventCheckBox).get(0).click();
    }

    private void addAdditionalContactPerson() {
        $("#first_name").setValue("John");
        $("#last_name").setValue("Doe");
        $("div.Select-placeholder").click();
        $(By.xpath("//*[text()='Ukraine']")).click();
        $("input[placeholder='Enter Your Mobile Number *']").setValue("676122892");
        $("#email").setValue("imartynenko@s-pro.io");
    }

    private void chooseTimeZone() {
        $$("div.Select-control").get(2).click();
        $(By.xpath("//*[text()='(UTC-06:00) Central Time (US & Canada)']")).click();
    }

    private void chooseEventEndTime() {
        $("input[placeholder='End Time']").click();
        $$(timePickers).get(0).$$("li").get(5).click();
        $$(timePickers).get(1).$$("li").get(15).click();
        $$(timePickers).get(2).$$("li").get(1).click();
    }

    private void chooseEventStartTime() {
        $("input[placeholder='Start Time']").click();
        $$(timePickers).get(0).$$("li").get(7).click();
        $$(timePickers).get(1).$$("li").get(30).click();
        $$(timePickers).get(2).$$("li").get(1).click();
    }
}
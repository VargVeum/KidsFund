package com.kidsFund.autotests.AdminTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class HelpListTest extends BaseTest {

    private final String filterDropdown = "div[role='button']";
    private final String openEventsList = "li[role='button']";
    private final By pageName = By.xpath("//h2[text()='Help Requests']");
    private final String filterButton = "button[role='button']";
    private final String clearButton = "button[role='button']";
    private final String subjectField = "#subject";
    private final String emailField = "#email";
    private final String bodyField = "#body";
    private final String sortingButton = "span[role='button']";

    @Test
    public void adminLogin() {
        loginAdminPanel();
        $$(openEventsList).get(6).click();
        $(pageName).shouldBe(Condition.visible);
        $$(filterDropdown).get(1).click();
        searchBySubjectTitle();
        searchByEmail();
        searchByBody();
        searchByCreationDate();
        checkingFilters();

        close();

    }

    private void checkingFilters() {
        $$(sortingButton).get(0).click();
        $$(sortingButton).get(1).click();
        $$(sortingButton).get(2).click();
        $$(sortingButton).get(3).click();
    }

    private void searchBySubjectTitle() {
        $(subjectField).setValue("AUTO help request");
        $$(filterButton).get(4).click();
        $(byText("AUTO help request")).shouldBe(Condition.visible);
        $$(clearButton).get(3).click();
        $(byText("AUTO help request")).shouldNotBe(Condition.visible);
    }

    private void searchByEmail() {
        $(emailField).setValue("imartynenko+5@s-pro.io");
        $$(filterButton).get(4).click();
        $(byText("imartynenko+5@s-pro.io")).shouldBe(Condition.visible);
        $$(clearButton).get(3).click();
        $(byText("imartynenko+5@s-pro.io")).shouldNotBe(Condition.visible);
    }

    private void searchByBody() {
        $(bodyField).setValue("Help test message for AUTO test");
        $$(filterButton).get(4).click();
        $(byText("Help test message for AUTO test")).shouldBe(Condition.visible);
        $$(clearButton).get(3).click();
        $(byText("Help test message for AUTO test")).shouldNotBe(Condition.visible);
    }

    private void searchByCreationDate() {
        $("#created_at").sendKeys("01-31-2018");
        $$(filterButton).get(4).click();
        $(byText("Help test message for AUTO test")).shouldBe(Condition.visible);
        $$(clearButton).get(3).click();
        $(byText("Help test message for AUTO test")).shouldNotBe(Condition.visible);
    }



}

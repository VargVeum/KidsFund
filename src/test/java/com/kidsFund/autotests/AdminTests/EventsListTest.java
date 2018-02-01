package com.kidsFund.autotests.AdminTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class EventsListTest extends BaseTest {

    private final String filterDropdown = "div[role='button']";
    private final String openEventsList = "li[role='button']";
    private final By pageName = By.xpath("//h2[text()='Events']");
    private final String filterButton = "button[role='button']";
    private final String clearButton = "button[role='button']";
    private final String eventTitle = "#title";
    private final String descriptionField = "#description";
    private final String sortingButton = "span[role='button']";

    @Test
    public void adminLogin() {
        loginAdminPanel();
        $$(openEventsList).get(5).click();
        $(pageName).shouldBe(Condition.visible);
        $$(filterDropdown).get(1).click();
        searchBySchoolTitle();
        searchByChildName();
        checkingFilters();

        close();

    }

    private void checkingFilters() {
        $$(sortingButton).get(0).click();
        $$(sortingButton).get(1).click();
        $$(sortingButton).get(2).click();
        $$(sortingButton).get(3).click();
        $$(sortingButton).get(4).click();
        $$(sortingButton).get(5).click();
        $$(sortingButton).get(6).click();
        $$(sortingButton).get(7).click();
    }

    private void searchBySchoolTitle() {
        $(eventTitle).setValue("4.01 Event #2");
        $$(filterButton).get(5).click();
        $(byText("4.01 Event #2")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
        $(byText("4.01 Event #2")).shouldNotBe(Condition.visible);
    }

    private void searchByChildName() {
        $(descriptionField).setValue("4.01 Event #2 description");
        $$(filterButton).get(5).click();
        $(byText("4.01 Event #2 description")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
        $(byText("4.01 Event #2 description")).shouldNotBe(Condition.visible);
    }

}

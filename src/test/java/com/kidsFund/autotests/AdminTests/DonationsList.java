package com.kidsFund.autotests.AdminTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DonationsList extends BaseTest {

    private final String filterDropdown = "div[role='button']";
    private final String openDonationsList = "li[role='button']";
    private final By pageName = By.xpath("//h2[text()='Donations list']");
    private final String filterButton = "button[role='button']";
    private final String clearButton = "button[role='button']";
    private final String sortingButton = "span[role='button']";
    private final String selectStatus = "div[role='button']";
    private final String chooseStatus = "ul[role='listbox'] li";
    private final String donorNameField = "#donor_full_name";
    private final String childNameField = "#child_full_name";

    @Test
    public void adminLogin() {
        loginAdminPanel();
        $$(openDonationsList).get(7).click();
        $(pageName).shouldBe(Condition.visible);
        $$(filterDropdown).get(1).click();
        filterByStatus();
        filterByFund();
        filterByFees();
        filterByDonorName();
        filterByChildName();
        checkingFilters();

    }

    private void filterByChildName() {
        $(childNameField).setValue("Dunia");
        $$(filterButton).get(5).click();
        $(byText("Dunia Kulakova")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
    }

    private void filterByDonorName() {
        $(donorNameField).setValue("Alex");
        $$(filterButton).get(5).click();
        $(byText("Alex Chuk")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
    }

    private void filterByStatus() {
        $$(selectStatus).get(2).click();
        $$(chooseStatus).get(2).click();
        $$(filterButton).get(5).click();
        $(byText("Devid Der")).shouldBe(Condition.visible);
    }

    private void filterByFund() {
        $$(selectStatus).get(3).click();
        $$(chooseStatus).get(2).click();
        $$(filterButton).get(5).click();
        $(byText("Devid Der")).shouldBe(Condition.visible);
    }

    private void filterByFees() {
        $$(selectStatus).get(4).click();
        $$(chooseStatus).get(2).click();
        $$(filterButton).get(5).click();
        $(byText("Devid Der")).shouldBe(Condition.visible);
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
        $$(sortingButton).get(8).click();
        $$(sortingButton).get(9).click();
        $$(sortingButton).get(10).click();
        $$(sortingButton).get(11).click();

    }

}

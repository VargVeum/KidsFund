package com.kidsFund.autotests.AdminTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class WishListTest extends BaseTest {

    private final String filterDropdown = "div[role='button']";
    private final String openWishesList = "li[role='button']";
    private final By pageName = By.xpath("//h2[text()='Wishes List']");
    private final String filterButton = "button[role='button']";
    private final String clearButton = "button[role='button']";
    private final String wishTitle = "#title";
    private final String childNameField = "#child_name";
    private final String sortingButton = "span[role='button']";


    @Test
    public void adminLogin() {
        loginAdminPanel();
        $$(openWishesList).get(3).click();
        $(pageName).shouldBe(Condition.visible);
        $$(filterDropdown).get(1).click();
        searchByWishTitle();
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

    private void searchByWishTitle() {
        $(wishTitle).setValue("Dog Company");
        $$(filterButton).get(5).click();
        $(byText("Dog Company")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
        $(byText("Dog Company")).shouldNotBe(Condition.visible);
    }

    private void searchByChildName() {
        $(childNameField).setValue("Charlies");
        $$(filterButton).get(5).click();
        $(byText("Dog Company")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
    }


}

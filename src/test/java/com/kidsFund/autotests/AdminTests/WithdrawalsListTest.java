package com.kidsFund.autotests.AdminTests;

//тест не дописан, нужны другие тестовые данные для проверки

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WithdrawalsListTest extends BaseTest {

    private final String filterDropdown = "div[role='button']";
    private final String openDonationsList = "li[role='button']";
    private final By pageName = By.xpath("//h2[text()='Donations list']");
    private final String filterButton = "button[role='button']";
    private final String clearButton = "button[role='button']";
    private final String sortingButton = "span[role='button']";
    private final String userNameField = "#user_full_name";
    private final String childNameField = "#child_full_name";

    @Test
    public void adminLogin() {
        loginAdminPanel();
        $$(openDonationsList).get(8).click();
        $(pageName).shouldBe(Condition.visible);
        $$(filterDropdown).get(1).click();
        //
        $(userNameField).setValue("");
        $$(filterButton).get(5).click();
        $(byText("Alex Chuk")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
    }

}

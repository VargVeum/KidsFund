package com.kidsFund.autotests.AdminTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class ChildrenListTest extends BaseTest {

    private final String filterDropdown = "div[role='button']";
    private final String openChildrenList = "li[role='button']";
    private final By pageName = By.xpath("//h2[text()='Children List']");
    private final String nicknameField = "input[name='nickname']";
    private final String filterButton = "button[role='button']";
    private final String clearButton = "button[role='button']";
    private final String lastNameField = "#last-name";
    private final String firstNameField = "#first-name";
    private final String chooseGender = "ul[role='listbox'] li";
    private final String clickGenderDropdown = "div[role='button']";
    private final String birthdayDateField = "#date_of_birth";
    private final String registrationNameField = "#created_at";
    private final String sortingButton = "span[role='button']";

    @Test
    public void adminLogin() {
        loginAdminPanel();
        openChildrenPage();
        verifyPageName();
        clickFilterDropdown();
        searchByFirstName();
        searchByLastName();
        searchByNickname();
        searchByGender();
        searchByBirthday();
        searchByRegistrationDate();
        checkingFilters();

        close();

    }

    private void clickFilterDropdown() {
        $$(filterDropdown).get(1).click();
    }

    private void verifyPageName() {
        $(pageName).shouldBe(Condition.visible);
    }

    private void checkingFilters() {
        $$(sortingButton).get(0).click();
        $$(sortingButton).get(1).click();
        $$(sortingButton).get(2).click();
        $$(sortingButton).get(3).click();
        $$(sortingButton).get(4).click();
        $$(sortingButton).get(5).click();
    }

    private void searchByRegistrationDate() {
        $(registrationNameField).sendKeys("12-18-2017");
        $$(filterButton).get(5).click();
        $(byText("Fencherch")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
        $(byText("Fencherch")).shouldNotBe(Condition.visible);
    }

    private void searchByBirthday() {
        $(birthdayDateField).sendKeys("07-14-2005");
        $$(filterButton).get(5).click();
        $(byText("Iosya")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
        $(byText("Iosya")).shouldNotBe(Condition.visible);
    }

    private void searchByGender() {
        $$(clickGenderDropdown).get(2).click();
        $$(chooseGender).get(2).click();
        $$(filterButton).get(5).click();
        $(byText("Barbara")).shouldBe(Condition.visible);
    }

    private void searchByNickname() {
        $(nicknameField).setValue("Fanny");
        $$(filterButton).get(5).click();
        $(byText("Fanny")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
        $(byText("Fanny")).shouldNotBe(Condition.visible);
    }

    private void searchByLastName() {
        $(lastNameField).setValue("Pupkin");
        $$(filterButton).get(5).click();
        $(byText("Pupkin")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
    }

    private void openChildrenPage() {
        $$(openChildrenList).get(2).click();
    }

    private void searchByFirstName() {
        $(firstNameField).shouldBe(Condition.visible).setValue("Charlies");
        $$(filterButton).get(5).click();
        $(byText("Charlies")).shouldBe(Condition.visible);
        $$(clearButton).get(4).click();
    }




}

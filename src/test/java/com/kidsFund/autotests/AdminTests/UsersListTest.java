package com.kidsFund.autotests.AdminTests;

//нужно доделать тест по отображению количества карточек на странице

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class UsersListTest extends BaseTest {

    private final String filterDropdown = ".c296.c287.c440";
    private final String firstNameField = "#first-name";
    private final String lastNameField = "#last-name";
    private final By filterButton = By.xpath("//span[text()='Filter']");
    private final By clearButton = By.xpath("//span[text()='Clear']");
    private final By firstNameFilter = By.xpath("//span[text()='First Name']");
    private final By lastNameFilter = By.xpath("//span[text()='Last Name']");
    private final By registrationDateFilter = By.xpath("//span[text()='Registration Date']");
    private final By birthdayFilter = By.xpath("//span[text()='Birthday']");
    private final By nationalityFilter = By.xpath("//span[text()='Nationality']");
    private final String emailField = "input.c470.c473.c471";
    private final String mobileNumberField = "input.c470.c473.c471";
    private final String registrationDate = "#created_at";
    private final String selectStatusDropdown = ".c476";
    private final By chooseInactiveStatus = By.xpath("//*[text()='INACTIVE']");
    private final String selectVerifiedDropdown = "form div[role='button']";
    private final String chooseNo = "ul[role='listbox'] li";
    private final String tableRows = "tbody tr";
    private final String rowsPerPageDropdown = "tfoot div[role='button']";
    private final String numberOfDdisplayedUsers = "div[role='document'] ul li";
    private final By chooseNoVerified = By.xpath("//*[text()='NO']");

    @Test
    public void adminLogin() {
        loginAdminPanel();
        filterChecking();
        $(filterDropdown).click();
        searchByFirstName();
        searchByLastName();
        searchByEmail();
        searchByMobile();
        searchByRegistrationDate();
        searchByStatus();
        searchByEmailVerified();
        searchByMobileVerified();
        checkTheNumberOfUsersOnThePage();

        close();

    }

    private void checkTheNumberOfUsersOnThePage() {
        $(rowsPerPageDropdown).click();
        $$(numberOfDdisplayedUsers).get(0).click();
        $$(tableRows).shouldBe(CollectionCondition.size(5));
        $(rowsPerPageDropdown).click();
        $$(numberOfDdisplayedUsers).get(1).click();
        $$(tableRows).shouldBe(CollectionCondition.size(10));
        $(rowsPerPageDropdown).click();
        $$(numberOfDdisplayedUsers).get(2).click();
        $$(tableRows).shouldBe(CollectionCondition.sizeGreaterThan(10));
    }

    private void filterChecking() {
        $(firstNameFilter).click();
        $(lastNameFilter).click();
        $(registrationDateFilter).click();
        $(birthdayFilter).click();
        $(nationalityFilter).click();
    }

    private void searchByFirstName() {
        $(firstNameField).setValue("Martin");
        $(filterButton).click();
        $(byText("2017-12-18")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Martin")).shouldNotBe(Condition.visible);
    }

    private void searchByLastName() {
        $(lastNameField).setValue("Iger");
        $(filterButton).click();
        $(byText("2017-12-18")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Martin")).shouldNotBe(Condition.visible);
    }

    private void searchByEmail() {
        $$(emailField).get(2).setValue("imartynenko@s-pro.io");
        $(filterButton).click();
        $(byText("Martin")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Martin")).shouldNotBe(Condition.visible);
    }

    private void searchByMobile() {
        $$(mobileNumberField).get(3).setValue("+380666274975");
        $(filterButton).click();
        $(byText("Voda")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Voda")).shouldNotBe(Condition.visible);
    }

    private void searchByRegistrationDate() {
        $(registrationDate).click();
        $(registrationDate).sendKeys("12-27-2017");
        $(filterButton).click();
        $(byText("Voda")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Voda")).shouldNotBe(Condition.visible);
    }

    private void searchByStatus(){
        $(selectStatusDropdown).click();
        $(chooseInactiveStatus).click();
        $(filterButton).click();
        $(byText("Kelly")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Kelly")).shouldNotBe(Condition.visible);
    }

    private void searchByEmailVerified(){
        $$(selectVerifiedDropdown).get(1).click();
        $$(chooseNo).get(2).click();
        $(filterButton).click();
        $(firstNameFilter).click();
        $(byText("Sanny")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Sanny")).shouldNotBe(Condition.visible);
    }

    private void searchByMobileVerified(){
        $$(selectVerifiedDropdown).get(2).click();
        $$(chooseNo).get(2).click();
        $(filterButton).click();
        $(byText("Qwe")).shouldBe(Condition.visible);
        $(clearButton).click();
        $(byText("Qwe")).shouldNotBe(Condition.visible);
    }








}

package com.kidsFund.autotests.ChildTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class AddSecondParentFromNewPerson extends BaseTest {

    private final String yourChildrenButton = ".sc-eilVRo.cVCgOO";
    private final By goToChildPage = By.xpath("//*[text()='Manny']");
    private final String addNewButton = "a.sc-eXEjpC.jqdoRx";
    private final By newPersonButton = By.xpath("//*[text()='New Person']");
    private final String firstNameField = "#firstName";
    private final String lastNameField = "#lastName";
    private final String emailField = "#email";
    private final String mobileNumberField = "input.sc-ckVGcZ.iyroHP";
    private final String submitButton = "button[type='submit']";
    private final By confirmButton = By.xpath("//button[text()='Confirm']");
    private final By chooseRole = By.xpath("//*[text()='Tutor']");

    @Test
    public void userLogin() {
        loginViaEmail();
        openYourChildrenButton();
        goToChildPage();
        clickAddNewButton();
        clickNewPersonButton();
        verifySuccessfulOpenPage();
        chooseSecondParentRole();
        fillTextInputFields();
        selectCountryCode();
        fillMobileNumberField();
        clickSubmitButton();
        verifySuccessfulOpenConfirmPage();
        clickConfirmButton();

        close();

    }

    private void verifySuccessfulOpenConfirmPage() {
        $(byText("You requested to add the following person to be added as Second Parent and Administrator of")).shouldBe(Condition.visible);
    }

    private void verifySuccessfulOpenPage() {
        $(byText("Add Second Parent")).shouldBe(Condition.visible);
    }

    private void clickConfirmButton() {
        $(confirmButton).click();
    }

    private void clickSubmitButton() {
        $(submitButton).click();
    }

    private void clickNewPersonButton() {
        $(newPersonButton).click();
    }

    private void clickAddNewButton() {
        $(addNewButton).click();
    }

    private void chooseSecondParentRole() {
        $$("div.Select-control").get(0).click();
        $(chooseRole).click();
    }

    private void fillMobileNumberField() {
        $(mobileNumberField).setValue("676122892");
    }

    private void fillTextInputFields() {
        $(firstNameField).setValue("Auto");
        $(lastNameField).setValue("Test");
        $(emailField).setValue("imartynenko+13@s-pro.io");
    }

    private void selectCountryCode() {
        $$("div.Select-control").get(1).click();
        $(By.xpath("//*[text()='Ukraine']")).click();
    }

    private void openYourChildrenButton() {
        $$(yourChildrenButton).get(0).click();
    }

    private void goToChildPage() {
        $(goToChildPage).click();
    }

}

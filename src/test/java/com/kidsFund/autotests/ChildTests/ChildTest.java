package com.kidsFund.autotests.ChildTests;

//In this test, we first create a child profile, then edit some data and then delete the created account

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class ChildTest extends BaseTest {

    //Create child
    private final String createChildAccountButton = ".sc-hzDEsm.cchEVv";
    private final String ViewYourChildrenButton = ".text.sc-eerKOB.jJmBsj";
    private final String FieldToUploadPhoto = ".sc-clNaTc.iqgpTJ";
    private final String AcceptUploadFile = ".UppyButton--circular.UppyButton--blue.UppyDashboard-upload";
    private final By addNewChildButton = By.xpath("//*[text()='Add New Child']");
    //Edit child
    private final String editButton = ".sc-gxMtzJ.kQhNVs";
    private final String updateChildAccount = ".sc-hzDEsm.cchEVv";
    private final String yourChildrenButton = ".sc-eilVRo.cVCgOO";
    //Delete child
    private final String deleteChildButton = "button.sc-gqPbQI.cCsecK";
    private final String confirmDeleteAction = ".sc-likbZx.knLNcY";

    @Test
    public void userLogin() {
        loginViaEmail();

        // Create new child test

        goToYourChildrenPage();
        clickAddNewChildButton();
        uploadChildPhoto();
        fillOtherFields();
        createNewChildAccount();
        checkAppearSuccessMessage();
        goToYourChildrenPage();

        // Edit child info

        chooseChildAccountToEdit();
        editChildInfo();
        checkAppearSuccessMessage();
        goToYourChildrenPage();

        // Delete child

        goToYourChildrenPage();
        clickDeleteChildButton();
        confirmDeleteAction();
        goToYourChildrenPage();

        close();

        }

    private void clickAddNewChildButton() {
        $(addNewChildButton).click();
    }

    private void confirmDeleteAction() {
        $(confirmDeleteAction).click();
    }

    private void clickDeleteChildButton() {
        $$(deleteChildButton).last().click();
    }

    private void chooseChildAccountToEdit() {
        $(yourChildrenButton).waitUntil(Condition.visible, 5000).click();
        $$("p.sc-esOvli.byLCzJ").last().shouldHave(text("NewAuto Test")).click();
    }

    private void editChildInfo() {
        $(editButton).click();
        $("#first_name").clear();
        $("#first_name").setValue("EDITED");
        $(updateChildAccount).click();
    }

    private void createNewChildAccount() {
        $(createChildAccountButton).click();
    }

    private void goToYourChildrenPage() {
        $(ViewYourChildrenButton).click();
    }

    private void checkAppearSuccessMessage() {
        $("div.successMessage").waitUntil(Condition.visible, 5000);
    }

    private void fillOtherFields() {
        $("#first_name").setValue("NewAuto");
        $("#last_name").setValue("Test");
        $("#nickname").setValue("Child");
        $("div.Select-placeholder").click();
        $(By.xpath("//*[text()='First name Last name']")).click();
        $("div.Select-placeholder").click();
        $(By.xpath("//*[text()='Other']")).click();
        $("div.Select-placeholder").click();
        $(By.xpath("//*[text()='Tutor']")).click();
        $("div.Select-placeholder").click();
        $(By.xpath("//*[text()='Sole Authority']")).click();
        $("div.react-datepicker__input-container").click();
        $(By.xpath("//*[text()='1']")).click();
    }

    private void uploadChildPhoto() {
        $(FieldToUploadPhoto).shouldBe(Condition.visible).click();
        File file = new File("img/KFverybig.jpg");
        $$("input[type='file']").last().uploadFile(file);
        $(AcceptUploadFile).click();
    }

}


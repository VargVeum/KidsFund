package com.kidsFund.autotests.ContentTests;

//In this test, we first create the child's wish, then we edit some data and then delete the created wish

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class ChildWishTest extends BaseTest {

    //Create child wish
    private final By submitButton = By.xpath("//*[text()='Submit']");
    private final By yourChildrenButton = By.xpath("//*[text()='Your Children']");
    private final By chooseChildAccount = By.xpath("//*[text()='Manny']");
    private final By homePageButton = By.xpath("//*[text()='Home Page']");
    private final By addNewWishButton = By.xpath("//*[text()='Add Wish']");
    private final String clickUploadPhotoButton = ".sc-keVrkP.dAESxd";
    private final String confirmUploadWishPhoto = ".UppyButton--circular.UppyButton--blue.UppyDashboard-upload";
    private final String wishTitle = "#title";
    private final String wishDescription = "#description";
    private final String wishCost = "#cost";
    //Edit child wish
    private final By viewAllButton = By.xpath("//*[text()='View All']");
    private final By editWishButton = By.xpath("//*[text()='Edit Wish']");
    private final String deleteEditTitle = "#title";
    private final String SetNewTitle = "#title";
    private final String deleteWishDescription = "#description";
    private final String setNewDescription = "#description";
    private final By chooseTestWish = By.xpath("//*[text()='Auto wish']");
    //Delete child wish
    private final By chooseEditedTestWish = By.xpath("//*[text()='EDITED wish']");
    private final By deleteButton = By.xpath("//*[text()='Delete']");
    private final By confirmDeleteWish = By.xpath("//*[text()='Yes']");

    @Test
    public void userLogin() {
        loginViaEmail();

        //Create wish

        $(yourChildrenButton).click();
        $(chooseChildAccount).click();
        $(homePageButton).click();
        $(addNewWishButton).click();
        addWishPhoto();
        fillOtherField();
        VerifySuccesfulCreationWish();

        //Edit wish

        chooseEventToEdit();
        editWishInfo();
        submitWishInfoChanges();
        verifySuccessEditWish();

        //Delete wish

        chooseWishToDelete();
        confirmDeleteAction();
        verifySuccesfulDeleteWish();

        close();
        }

    private void verifySuccesfulDeleteWish() {
        $(By.xpath("//*[text()='Wish Cover Photo']")).shouldBe(Condition.disappear);
        Assert.assertTrue($$(By.xpath("//*[text()='EDITED wish']")).size() > 0, "Wish isn't edited!");
    }

    private void confirmDeleteAction() {
        $(editWishButton).click();
        $(deleteButton).click();
        $(confirmDeleteWish).click();
    }

    private void chooseWishToDelete() {
        $(yourChildrenButton).click();
        $(chooseChildAccount).click();
        $(homePageButton).click();
        $(viewAllButton).click();
        $(By.xpath("//button[text()='Reorder Wishes']")).shouldBe(Condition.visible);
        $(chooseEditedTestWish).shouldHave(Condition.text("EDITED wish")).shouldBe(Condition.visible).click();
    }

    private void verifySuccessEditWish() {
        $(By.xpath("//*[text()='Wish Cover Photo']")).shouldBe(Condition.disappear);
        Assert.assertTrue($$(By.xpath("//*[text()='Auto wish']")).size() > 0, "Wish isn't edited!");
    }

    private void submitWishInfoChanges() {
        $(submitButton).click();
    }

    private void editWishInfo() {
        $(editWishButton).click();
        $(deleteEditTitle).clear();
        $(SetNewTitle).setValue("EDITED wish");
        $(deleteWishDescription).clear();
        $(setNewDescription).setValue("EDITED description");
    }

    private void chooseEventToEdit() {
        $(yourChildrenButton).click();
        $(chooseChildAccount).click();
        $(homePageButton).click();
        $(viewAllButton).click();
        $(chooseTestWish).shouldHave(Condition.text("Auto wish")).shouldBe(Condition.visible).click();
    }

    private void VerifySuccesfulCreationWish() {
        $(By.xpath("//*[text()='Wish Cover Photo']")).shouldBe(Condition.disappear);
        Assert.assertTrue($$(By.xpath("//*[text()='Auto wish']")).size() > 0, "Wish isn't created!");
    }

    private void fillOtherField() {
        $(wishTitle).setValue("Auto wish");
        $(wishDescription).setValue("Description Auto Wish");
        $(wishCost).setValue("800");
        submitWishInfoChanges();
    }

    private void addWishPhoto() {
        $(clickUploadPhotoButton).shouldBe(Condition.visible).click();
        File file = new File("img/toy1.jpg");
        $$("input[type='file']").last().uploadFile(file);
        $(confirmUploadWishPhoto).click();
    }


}

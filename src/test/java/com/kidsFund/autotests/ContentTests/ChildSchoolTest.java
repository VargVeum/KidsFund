package com.kidsFund.autotests.ContentTests;

//In this test we create School on the child page, then edit school info and then delete created school

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class ChildSchoolTest extends BaseTest {

    //Create school
    private final By yourChildrenButton = By.xpath("//*[text()='Your Children']");
    private final By chooseChildAccount = By.xpath("//*[text()='Manny']");
    private final By homePageButton = By.xpath("//*[text()='Home Page']");
    private final By viewAllButton = By.xpath("//*[text()='View All']");
    private final By addSchoolButton = By.xpath("//button[text()='Add School']");
    private final String clickUploadPhotoButton = ".sc-keVrkP.dAESxd";
    private final String confirmUploadWishPhoto = ".UppyButton--circular.UppyButton--blue.UppyDashboard-upload";
    private final By submitButton = By.xpath("//*[text()='Submit']");
    private final By clickMainLogo = By.xpath("//*[text()='Kids Fund']");
    private final By schoolPostName = By.xpath("//*[text()='Auto school']");
    //Edit school
    private final By clickSumbitButton = By.xpath("//button[text()='Submit']");
    private final By editSchoolButton = By.xpath("//*[text()='Edit']");
    //Delete school
    private final By reorderSchoolsButton = By.xpath("//button[text()='Reorder Schools']");
    private final By schoolButton = By.xpath("//div[text()='EDITED school']");
    private final By deleteButton = By.xpath("//button[text()='Delete']");


    @Test
    public void userLogin() {
        loginViaEmail();

        //Create School

        addNewSchool();
        addSchoolPhoto();
        fillOtherField();
        submitCreateSchool();
        verifySuccessCreateSchoolAtChildPage();
        verifySuccessCreateSchoolAtParentPage();

        //Edit school

        goToChildPage();
        chooseSchoolToEdit();
        editSchoolInfo();
        submitEditSchoolInfo();
        verifySuccesfulEditSchool();

        //Delete school

        goToChildPage();
        viewAllSchool();
        chooseSchoolToDelete();
        verifySuccessDeleteSchool();

        close();
        }

    private void viewAllSchool() {
        $(chooseChildAccount).click();
        $(homePageButton).click();
        $$(viewAllButton).get(1).click();
    }

    private void verifySuccessDeleteSchool() {
        $(By.xpath("//*[text()='Are you shure that you want to delete this Course/School?']")).shouldBe(Condition.disappear);
    }

    private void chooseSchoolToDelete() {
        $(reorderSchoolsButton).shouldBe(Condition.visible);
        $(schoolButton).waitUntil(Condition.visible, 5000).click();
        $(editSchoolButton).click();
        $(deleteButton).click();
        $(By.xpath("//*[text()='Are you shure that you want to delete this Course/School?']")).shouldBe(Condition.visible);
        $(By.xpath("//button[text()='Yes']")).click();
    }

    private void goToChildPage() {
        $(yourChildrenButton).click();
    }

    private void verifySuccesfulEditSchool() {
        $(By.xpath("//*[text()='Course/School Photo']")).shouldBe(Condition.disappear);
        Assert.assertTrue($$(By.xpath("//*[text()='EDITED school']")).size() > 0, "School isn't edited!");
    }

    private void submitEditSchoolInfo() {
        $(clickSumbitButton).click();
    }

    private void editSchoolInfo() {
        $(By.xpath("//div[text()='Auto school']")).waitUntil(Condition.visible, 5000).click();
        $(editSchoolButton).click();
        $("#title").clear();
        $("#title").setValue("EDITED school");
        $("#cost_per_term").clear();
        $("#cost_per_term").setValue("1121");
    }

    private void chooseSchoolToEdit() {
        viewAllSchool();
        $(By.xpath("//button[text()='Reorder Schools']")).shouldBe(Condition.visible);
    }

    private void verifySuccessCreateSchoolAtParentPage() {
        $(clickMainLogo).click();
        $(schoolPostName).shouldBe(Condition.visible);
    }

    private void verifySuccessCreateSchoolAtChildPage() {
        $(By.xpath("//*[text()='Course/School Photo']")).shouldBe(Condition.disappear);
        Assert.assertTrue($$(By.xpath("//*[text()='Auto school']")).size() > 0, "School isn't created!");
    }

    private void submitCreateSchool() {
        $(submitButton).click();
    }

    private void fillOtherField() {
        $("#title").setValue("Auto school");
        $("#description").setValue("Auto school description");
        $("#number_of_terms").setValue("7");
        $("#cost_per_term").setValue("1311");
    }

    private void addSchoolPhoto() {
        $(clickUploadPhotoButton).shouldBe(Condition.visible).click();
        File file = new File("img/School1.jpg");
        $$("input[type='file']").last().uploadFile(file);
        $(confirmUploadWishPhoto).click();
    }

    private void addNewSchool() {
        goToChildPage();
        viewAllSchool();
        $(addSchoolButton).click();
    }

}

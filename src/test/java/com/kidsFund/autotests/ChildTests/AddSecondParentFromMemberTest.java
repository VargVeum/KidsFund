package com.kidsFund.autotests.ChildTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class AddSecondParentFromMemberTest extends BaseTest {

    private final String yourChildrenButton = ".sc-eilVRo.cVCgOO";
    private final By goToChildPage = By.xpath("//*[text()='Manny']");
    private final String addSecondParentButton = ".sc-eXEjpC.jqdoRx";
    private final String searchMemberField = ".sc-jwKygS.hjuiua";
    private final By addAsSecondParent = By.xpath("//*[text()='Add As Second Parent']");
    private final String areYouTheChild = "div.Select-control";

    @Test
    public void userLogin() {
        loginViaEmail();
        openYourChildrenButton();
        goToChildPage();
        chooseMemberForRoleSecondParent();
        addAsSecondParent();
        verifySuccessOpenPopUp();
        chooseRoleOfSecondParent();

        close();

    }

    private void verifySuccessOpenPopUp() {
        $(byText("Secong Parent Relationship")).shouldBe(Condition.visible);
    }

    private void openYourChildrenButton() {
        $$(yourChildrenButton).get(0).click();
    }

    private void addAsSecondParent() {
        $(addAsSecondParent).click();
    }

    private void chooseMemberForRoleSecondParent() {
        $(addSecondParentButton).click();
        $(searchMemberField).setValue("Nancy");
        $(byText("Nancy Wisemanstein")).shouldBe(Condition.visible);
    }

    private void goToChildPage() {
        $(goToChildPage).click();
    }

    private void chooseRoleOfSecondParent() {
        $(areYouTheChild).click();
        $(By.xpath("//*[text()='Tutor']")).click();
        $(By.xpath("//*[text()='Submit']")).click();
    }

}

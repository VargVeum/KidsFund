package com.kidsFund.autotests.FriendTests;

//In this test user send friendship request to KF member and later cancelled it

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;

public class AddFriendViaEmailTest extends BaseTest {

    private final By yourFriendsButton = By.xpath("//*[text()='Your Friends']");
    private final By addFriendButton = By.xpath("//*[text()='Add Friend']");
    private final String firstNameField = "#first_name";
    private final String lastNameField = "#last_name";
    private final String friendEmailButton = "#email";
    private final By inviteAllButton = By.xpath("//*[text()='Invite All']");
    private final By messageAfterSuccesfulSend = byText("Invites Was Successully Send");

    @Test
    public void userLogin() {
        loginViaEmail();
        clickYourFriendButton();
        clickAddFriendButton();
        fillInfoField();
        clickInviteButton();
        verifySuccesfulSentFriendshipInvite();

        close();

    }

    private void clickYourFriendButton() {
        $(yourFriendsButton).click();
    }

    private void clickAddFriendButton() {
        $(addFriendButton).click();
    }

    private void verifySuccesfulSentFriendshipInvite() {
        $(messageAfterSuccesfulSend).shouldBe(Condition.visible);
    }

    private void clickInviteButton() {
        $(inviteAllButton).click();
    }

    private void fillInfoField() {
        $(firstNameField).setValue("Auto");
        $(lastNameField).setValue("Friend");
        $(friendEmailButton).setValue("imartynenko+36@s-pro.io");
    }

}
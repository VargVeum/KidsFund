package com.kidsFund.autotests.FriendTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class UnfriendTest extends BaseTest{

    private final By yourFriendsButton = By.xpath("//*[text()='Your Friends']");
    private final By addFriendButton = By.xpath("//*[text()='Add Friend']");
    private final String yourFriendButton = "div.sc-jVODtj.flehHd";
    private final By pendingRequests = By.xpath("//p[text()='Pending Requests']");
    private final By pendingRequestsReceivedButton = By.xpath("//button[text()='Pending Requests Received']");
    private final By acceptFriendshipRequest = By.xpath("//button[text()='Accept']");
    private final String menuDropdown = ".sc-eHgmQL.kSxpyt";
    private final String logoutButton = ".sc-gPEVay.ekxTKK";
    //private final String resendButton = "button.sc-ihiiSJ.DcgdO";
    private final By cancelButton = By.xpath("//button[text()='Cancel']");
    private final String chooseFriend = "button.sc-cIwbeI.bPMpJa";


    @Test
    public void userLogin() {
        loginViaEmail();
        goToYourFriendsPage();
        clickAddFriendButton();
        chooseUserToSentFriendshipRequest();
        sendFriendshipRequest();
        verifySuccesfulSentInvite();
        logoutFromAccount();

        close();

        loginViaFriend();
        goToYourFriendsPage();
        checkNumberOfFriends();
        openPendingRequests();
        choosePendingRequestsReceived();
        acceptFriendshipRequest();
        logoutFromAccount();

        close();

        loginViaEmail();
        goToYourFriendsPage();
        chooseFriend();
        verifyUnfriendAction();
        confirmUnfriendAction();
        verifySuccessfulunfriend();

        close();

    }

    private void verifySuccessfulunfriend() {
        $(byText("Api Test")).shouldNotBe(Condition.visible);
    }

    private void confirmUnfriendAction() {
        $("button.sc-likbZx.knLNcY").click();
    }

    private void verifyUnfriendAction() {
        $(byText("Are you sure you want to unfriend?")).shouldBe(Condition.visible);
    }

    private void chooseFriend() {
        $$(chooseFriend).last().click();
    }

    private void checkNumberOfFriends() {
        $(byText("There are no friends")).shouldBe(Condition.visible);
    }

    private void acceptFriendshipRequest() {
        $(acceptFriendshipRequest).click();
    }

    private void choosePendingRequestsReceived() {
        $(pendingRequestsReceivedButton).click();
    }

    private void openPendingRequests() {
        $(pendingRequests).click();
    }

    private void logoutFromAccount() {
        $(menuDropdown).shouldBe(Condition.visible).click();
        $(logoutButton).shouldBe(Condition.visible).click();
    }

    private void verifySuccesfulSentInvite() {
        $(By.xpath("//*[text()='Resend']")).shouldBe(Condition.visible);
    }

    private void sendFriendshipRequest() {
        $(By.xpath("//button[text()='Add Friend']")).shouldBe(Condition.visible).click();
    }

    private void chooseUserToSentFriendshipRequest() {
        $(By.xpath("//*[text()='Add Member']")).click();
        $(".sc-jwKygS.hjuiua").setValue("Api");
        $(byText("Api Test")).shouldBe(Condition.visible);
        if ($$(cancelButton).size() > 0 ) {
            $(cancelButton).click();
        } else {
            $(addFriendButton).click();
        }

        $(By.xpath("//*[text()='Api Test']")).waitUntil(Condition.visible, 5000).shouldBe(Condition.visible);
    }

    private void clickAddFriendButton() {
        $(addFriendButton).shouldBe(Condition.visible).click();
    }

    private void goToYourFriendsPage() {
        $(yourFriendsButton).click();
    }


}

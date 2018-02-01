package com.kidsFund.autotests.FriendTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class AddFriendFromMemberTest extends BaseTest {

    //Send friendship requests to KF member
    private final By yourFriendsButton = By.xpath("//*[text()='Your Friends']");
    private final By addFriendButton = By.xpath("//*[text()='Add Friend']");
    //Cancel friendship requsts
    private final By pendingRequestsButton = By.xpath("//*[text()='Pending Requests']");
    private final By chooseFriendAccount = By.xpath("//*[text()='Api Test']");
    private final By clickCancelButton = By.xpath("//button[text()='Cancel']");

    @Test
    public void userLogin() {
        loginViaEmail();

        //Send friendship requests

        goToYourFriendsPage();
        clickAddFriendButton();
        chooseUserToSentFriendshipRequest();
        sendFriendshipRequest();
        verifySuccesfulSentInvite();

        //Cancel friendship request

        goToYourFriendsPage();
        viewPendingRequest();
        cancelFriendshipRequest();
        verifyCancelFriendshipRequest();

        close();
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
        $(By.xpath("//*[text()='Api Test']")).waitUntil(Condition.visible, 5000).shouldBe(Condition.visible);
    }

    private void clickAddFriendButton() {
        $(addFriendButton).click();
    }

    private void goToYourFriendsPage() {
        $(yourFriendsButton).click();
    }

    private void verifyCancelFriendshipRequest() {
        $(By.xpath("//*[text()='Api Test']")).shouldNotBe(Condition.visible);
    }

    private void cancelFriendshipRequest() {
        $(chooseFriendAccount).waitUntil(Condition.visible, 5000).shouldBe(Condition.visible);
        $$(clickCancelButton).last().click();
    }

    private void viewPendingRequest() {
        $(pendingRequestsButton).click();
    }
}

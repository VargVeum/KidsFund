package com.kidsFund.autotests.ContentTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;

public class ChatWithAnotherUserTest extends BaseTest {


    private final By yourChatsButton = By.xpath("//*[text()='Your Chats']");
    private final By chooseFriendToStart = By.xpath("//*[text()='Finn Doe']");
    private final String inputMessageField = "input[placeholder='Type a message…']";
    private final By clickSendButton = By.xpath("//*[text()='Send']");

    @Test
    public void userLogin() {
        loginViaEmail();
        goToChats();
        startChatWithFriend();
        sendMessageToChat();
        verifySuccessfulSendMessage();

        close();

    }

    private void verifySuccessfulSendMessage() {
        $(byText("Test chat via Selenide")).shouldBe(Condition.visible);
    }

    private void sendMessageToChat() {
        $(inputMessageField).shouldBe(Condition.visible).setValue("Test message via Selenide");
        $(clickSendButton).click();
    }

    private void startChatWithFriend() {
        $(chooseFriendToStart).click();
    }

    private void goToChats() {
        $(yourChatsButton).click();
    }
}

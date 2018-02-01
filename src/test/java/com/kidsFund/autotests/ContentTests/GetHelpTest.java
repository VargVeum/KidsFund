package com.kidsFund.autotests.ContentTests;

import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class GetHelpTest extends BaseTest {

    private final String openURL = "http://kf-front.scenario-projects.com/";
    private final By openHelpPage = By.xpath("//*[text()='If You need any help please go to this page']");
    private final String emailField = "#email";
    private final String subjectField = "#subject";
    private final String helpMessageField = "#enquiry";
    private final By sendButton = By.xpath("//*[text()='Submit']");

    @Test
    public void userLogin () {
        openHonePage();
        goToHelpPage();
        fillHelpMessageField();
        sendMessage();

        close();

    }

    private void openHonePage() {
        open(openURL);
    }

    private void goToHelpPage() {
        $(openHelpPage).click();
    }

    private void sendMessage() {
        $(sendButton).click();
    }

    private void fillHelpMessageField() {
        $(emailField).setValue("imartynenko+10@s-pro.io");
        $(subjectField).setValue("AUTO test");
        $(helpMessageField).setValue("Test via Selenide");
    }


}


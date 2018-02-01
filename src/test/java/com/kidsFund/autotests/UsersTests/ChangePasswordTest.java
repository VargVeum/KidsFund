package com.kidsFund.autotests.UsersTests;

import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

public class ChangePasswordTest extends BaseTest{

    private final By yourSettingsButton = By.xpath("//*[text()='Your Settings']");
    private final By editInfoButton = By.xpath("//*[text()='Edit']");
    private final By changeAccountPassword = By.xpath("//*[text()='Change your password']");
    private final String enterYourCurrentPasswordField = "#oldPassword";
    private final String enterYourNewPasswordField = "#newPassword";
    private final String confirmYourNewPasswordField = "#reEnteredPassword";
    private final By submitButton = By.xpath("//*[text()='Submit']");
    private final By yourChildrenButton = By.xpath("//*[text()='Your Children']");

    @Test
    public void userLogin(){
        loginViaEmail();
        //Change the old password to a new one
        $(yourSettingsButton).click();
        $$(editInfoButton).first().click();
        $(changeAccountPassword).click();
        $(enterYourCurrentPasswordField).setValue("Qwerty123$");
        $(enterYourNewPasswordField).setValue("Qwerty123#");
        $(confirmYourNewPasswordField).setValue("Qwerty123#");
        $(submitButton).click();
        //Reserve change the new password to the old one
        $(yourSettingsButton).click();
        $$(editInfoButton).first().click();
        $(changeAccountPassword).click();
        $(enterYourCurrentPasswordField).setValue("Qwerty123#");
        $(enterYourNewPasswordField).setValue("Qwerty123$");
        $(confirmYourNewPasswordField).setValue("Qwerty123$");
        $(submitButton).click();
        //Redirect to the main page
        $(yourChildrenButton).click();

        close();

    }

}

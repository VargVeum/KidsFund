package com.kidsFund.autotests.ContentTests;

//Тест еще не доделан (!)

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class CreatePostOnUsersPageTest extends BaseTest{

    //Create post
    private final String createPostOnThePage = "textarea.sc-hlILIN.HBSOz";
    private final By submitButton = By.xpath("//button[text()='Submit']");

    @Test
    public void userLogin(){
        loginViaEmail();
        $(createPostOnThePage).setValue("Test post on the user's page");
        $(submitButton).waitUntil(Condition.visible, 5000).click();
        //Verify what wish will be succesfully deleted
        //$(By.xpath("//*[text()='Test post on the user's page']")).shouldBe(Condition.visible);



    }


}

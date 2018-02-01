package com.kidsFund.autotests.UsersTests;

import com.codeborne.selenide.Condition;
import com.kidsFund.autotests.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;

public class LoginViaEmailTest extends BaseTest{
    private final String menuDropdown = ".sc-eHgmQL.kSxpyt";
    private final String logoutButton = ".sc-gPEVay.ekxTKK";

    @Test
        public void userLogin() {
        loginViaEmail();
        $(menuDropdown).shouldBe(Condition.visible).click();
        $(logoutButton).shouldBe(Condition.visible).click();

        close();
    }
}

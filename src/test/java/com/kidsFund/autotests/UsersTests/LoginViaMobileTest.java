package com.kidsFund.autotests.UsersTests;

import com.kidsFund.autotests.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class LoginViaMobileTest extends BaseTest {
    private final String menuDropdown = ".sc-eHgmQL.kSxpyt";
    private final String logoutButton = ".sc-gPEVay.ekxTKK";

    @Test
        public void userLogin() {
        LoginViaPhone();
        $(menuDropdown).click();
        $(logoutButton).click();

        close();
    }




}

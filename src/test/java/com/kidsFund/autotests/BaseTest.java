package com.kidsFund.autotests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    private final String adminURL = "http://kf-admin.scenario-projects.com/login";
    private final String baseURL = "http://kf-front.scenario-projects.com/";
    private String login ="imartynenko@s-pro.io";
    private String password ="Qwerty123$";
    private String changedPassword ="Qwerty123#";
    private String phoneNumber = "666274975";
    private final String alreadyHaveAccountButton = ".sc-hmzhuo.eaRRuw";
    private final String loginButton = ".sc-cHGsZl.kKInxm";

    public String getLogin() {
        return login;
    }

    public String getChangedPassword() {
        return changedPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "/home/tester/Drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        browser = "chrome";
    }

    protected void loginAdminPanel(){
        open(adminURL);
        $(By.cssSelector("input[type='email']")).setValue(getLogin());
        $(By.cssSelector("input[type='password']")).setValue(getPassword());
        $(By.xpath("//*[text()='Submit']")).click();

    }

    protected void loginViaEmail() {
        open(baseURL);
        $(alreadyHaveAccountButton).click();
        $("#loginEmail").setValue(getLogin());
        $("#loginPassword").waitUntil(Condition.visible, 5000).setValue(getPassword());
        $(loginButton).click();
    }

    private void loginChangedPassword() {
        open(baseURL);
        $(alreadyHaveAccountButton).click();
        $("#loginEmail").setValue(getLogin());
        $("#loginPassword").waitUntil(Condition.visible, 5000).setValue(getChangedPassword());
        $(loginButton).click();
    }

    protected void LoginViaPhone() {
        open(baseURL);
        $(alreadyHaveAccountButton).shouldBe(Condition.visible).click();
        $(loginButton).shouldBe(Condition.visible);
        $$("span.radioTextItem").last().click();
        $("div.Select-placeholder").click();
        $(By.xpath("//*[text()='Ukraine']")).click();
        $("input.sc-ckVGcZ.iyroHP").setValue(getPhoneNumber());
        $("#loginPassword").setValue(getPassword());
        $(loginButton).click();
    }


}


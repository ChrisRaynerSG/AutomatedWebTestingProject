package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.WebDriver;

public class Website {
    private final WebDriver webDriver;
    private final LoginPage loginPage;
    private final SignupPage signupPage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.loginPage = new LoginPage(webDriver);
        this.signupPage = new SignupPage(webDriver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
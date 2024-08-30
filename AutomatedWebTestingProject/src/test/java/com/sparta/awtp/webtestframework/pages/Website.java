package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.WebDriver;

public class Website {
    private final WebDriver webDriver;
    private final LoginPage loginPage;
    private final SignupPage signupPage;
    private final ContactUsPage contactUsPage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.loginPage = new LoginPage(webDriver);
        this.signupPage = new SignupPage(webDriver);
        this.contactUsPage = new ContactUsPage(webDriver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }
    public ContactUsPage getContactUsPage(){
        return contactUsPage;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
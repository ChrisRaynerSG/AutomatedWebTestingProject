package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.HomePage;
import com.sparta.awtp.webtestframework.pages.LoginPage;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefs {
    private Website website;
    private LoginPage loginPage;
    private HomePage homePage;
    private static final String BASE_URL = "https://automationexercise.com/";
    private static final String LOGIN_PAGE_URL = "https://automationexercise.com/login";

    @Before("@login")
    public void setup() throws Exception {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
        website = TestSetup.getWebsite(LOGIN_PAGE_URL);
        homePage = website.getHomePage();
        loginPage = website.getLoginPage();
    }

    @After("@login")
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }

    @And("I have entered the username {string}")
    public void iHaveEnteredTheUsername(String username) {
        loginPage.handleCookiesPopup();
        loginPage.enterEmailLogin(username);
    }

    @And("I have entered the password {string}")
    public void iHaveEnteredThePassword(String password) {
        loginPage.enterPasswordLogin(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should land on the home page")
    public void iShouldLandOnTheHomePage() {
        String actualUrl = website.getCurrentUrl();
        Assertions.assertEquals(BASE_URL, actualUrl, "Login was not successful. Did not land on the home page.");
    }

    @Then("I should get an error message {string}")
    public void iShouldGetAnErrorMessage(String arg0) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assertions.assertEquals(arg0, actualErrorMessage, "Error message was not as expected.");
    }

    @And("I click the logout button")
    public void iClickTheLogoutButton() {
        homePage.clickLogoutButton();
    }

    @Then("I will be logged out and land on the login page")
    public void iWillBeLoggedOutAndLandOnTheLoginPage() {
        String actualUrl = website.getCurrentUrl();
        Assertions.assertEquals(LOGIN_PAGE_URL, actualUrl, "Did not land on the login page after logging out.");
    }
}

package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.LoginPage;
import com.sparta.awtp.webtestframework.pages.SignupPage;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class RegistrationStepDefs {

    private Website website;
    private LoginPage loginPage;
    private static final String LOGIN_PAGE_URL = "https://automationexercise.com/login";
    private static final String SIGNUP_PAGE_URL = "https://automationexercise.com/signup";
    private SignupPage signupPage;
    private static final String SUCCESS_MESSAGE = "Registration successful"; // Adjust this as needed

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        website = TestSetup.getWebsite(LOGIN_PAGE_URL);
        loginPage = website.getLoginPage();
        loginPage.handleCookiesPopup();  // Handle the cookies popup
    }

    @When("I enter a valid name and email address")
    public void iEnterAValidNameAndEmailAddress() {
        loginPage.enterName("TestUserToDel");
        loginPage.enterEmail("testusertodel@example.com");
    }

    @When("I click on the sign up button")
    public void iClickOnTheSignUpButton() {
        loginPage.clickSignUp();
    }

    @Then("I am sent to the signup page")
    public void iAmSentToTheSignupPage() {
        String currentUrl = website.getCurrentUrl();
        Assertions.assertEquals(SIGNUP_PAGE_URL, currentUrl);
    }
}
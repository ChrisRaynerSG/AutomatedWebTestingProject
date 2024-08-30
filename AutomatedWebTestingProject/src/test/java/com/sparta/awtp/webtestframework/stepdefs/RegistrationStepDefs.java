package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationStepDefs {

    private Website website;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private HomePage homePage;
    private AccountCreatedPage accountCreatedPage;
    private static final String LOGIN_PAGE_URL = "https://automationexercise.com/login";
    private static final String SIGNUP_PAGE_URL = "https://automationexercise.com/signup";


    @After("@registration")
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }

    @Before("@registration")
    public void setup() throws Exception {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
        website = TestSetup.getWebsite(LOGIN_PAGE_URL);
        loginPage = website.getLoginPage();
        signupPage = website.getSignupPage();
        homePage = website.getHomePage();
        accountCreatedPage = website.getAccountCreatedPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.handleCookiesPopup();
    }

    @And("I enter a valid name and email address")
    public void iEnterAValidNameAndEmailAddress() {
        loginPage.enterName("TestUserToDelpt1");
        loginPage.enterEmail("testuserpt1@example.com");
    }

    @And("I click on the sign up button")
    public void iClickOnTheSignUpButton() {
        loginPage.clickSignUp();
    }

    @And("I am sent to the signup page")
    public void iAmSentToTheSignupPage() {

        String currentUrl = website.getCurrentUrl();
        Assertions.assertEquals(SIGNUP_PAGE_URL, currentUrl, "Did not navigate to the signup page");
        Assertions.assertTrue(signupPage.isSignupFormDisplayed(), "Signup form is not displayed");
    }

    @When("I enter the following information")
    public void iEnterTheFollowingInformation(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);

        Map<String, String> dataMap = new HashMap<>();

        for (List<String> row : rows) {
            if (row.size() == 2) {
                String field = row.get(0).trim();
                String value = row.get(1).trim();
                dataMap.put(field, value);
            }
        }

        signupPage.enterPassword(dataMap.get("Password"));
        signupPage.enterFirstName(dataMap.get("First Name"));
        signupPage.enterLastName(dataMap.get("Last Name"));
        signupPage.enterAddress1(dataMap.get("Address 1"));
        signupPage.enterCountry(dataMap.get("Country"));
        signupPage.enterState(dataMap.get("State"));
        signupPage.enterCity(dataMap.get("City"));
        signupPage.enterZipcode(dataMap.get("Zipcode"));
        signupPage.enterMobileNumber(dataMap.get("Mobile Number"));
        signupPage.submitRegistrationForm();
    }

    @Then("I am successfully registered")
    public void iAmSuccessfullyRegistered() {
        String expectedUrl = "https://automationexercise.com/account_created";
        String actualUrl = website.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Registration was not successful. Did not navigate to the account creation confirmation page.");
    }

    @And("I continue to the home page")
    public void iContinueToTheHomePage() {
        accountCreatedPage.clickContinue();
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = website.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Did not navigate to the home page.");
    }

    @And("I can successfully delete my account")
    public void iCanSuccessfullyDeleteMyAccount() {
        homePage.clickDeleteAccount();

        String expectedUrl = "https://automationexercise.com/delete_account";
        String actualUrl = website.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Account deletion was not successful.");
    }

    @And("I enter a valid name {string}")
    public void iEnterAValidName(String name) {
        loginPage.enterName(name);
    }

    @And("I enter email address that is already registered {string}")
    public void iEnterEmailAddressThatIsAlreadyRegistered(String email) {
        loginPage.enterEmail(email);
    }

    @Then("error {string} should be displayed")
    public void errorShouldBeDisplayed(String error) {
        String actualError = loginPage.getErrorMessage();
        Assertions.assertEquals(error, actualError, "Error message is not displayed");
    }
}
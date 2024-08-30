package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.ContactUsPage;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class ContactUsStepDefs {
    private Website website;
    private ContactUsPage contactUsPage;
    private static final String CONTACT_US_PAGE_URL = "https://automationexercise.com/contact_us";
    private static final String SUCCESS_MESSAGE = "Success! Your details have been submitted successfully."; // Adjust this as needed


    @After("@contactus")
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }

    @Before("@contactus")
    public static void setup() throws Exception {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @Given("I am on the contact us page")
    public void iAmOnTheContactUsPage() {
        website = TestSetup.getWebsite(CONTACT_US_PAGE_URL);
        contactUsPage = website.getContactUsPage();
        contactUsPage.handleCookiesPopup();
    }

    @Then("The the url should be that of the contact us page {string}")
    public void theTheUrlShouldBeThatOfTheContactUsPage(String expected_url) {
        Assertions.assertEquals(expected_url, CONTACT_US_PAGE_URL);
    }

    @When("I enter all the valid details")
    public void iEnterAllTheValidDetails() {
        website.getContactUsPage().enterName("Test Name");
        website.getContactUsPage().enterEmail("Test@email.com");
        website.getContactUsPage().enterSubject("Test Subject");
        website.getContactUsPage().enterMessage("Test Message");
    }

    @Then("I will be be promoted with a success message {string}")
    public void iWillBeBePromotedWithASuccessMessage(String successMessage) {
        Assertions.assertEquals(successMessage, website.getContactUsPage().getSuccessMessage());
    }

    @And("click the submit button")
    public void clickTheSubmitButton() {
        website.getContactUsPage().clickSubmit();
    }

    @When("I enter an invalid email {string}")
    public void iEnterAnInvalidEmail(String invalidEmail) {
        if (Objects.equals(invalidEmail, "empty")){
            website.getContactUsPage().enterEmail("");
        }else{
            website.getContactUsPage().enterEmail(invalidEmail);
        }
        //correct details:
        website.getContactUsPage().enterName("Test Name");
        website.getContactUsPage().enterSubject("Test Subject");
        website.getContactUsPage().enterMessage("Test Message");
    }

    @Then("I will be prompted with the message {string}")
    public void iWillBePromptedWithTheMessage(String expectedErrorMessage) {
        Assertions.assertTrue(website.getContactUsPage().getErrorPrompt().contains(expectedErrorMessage));
    }


}

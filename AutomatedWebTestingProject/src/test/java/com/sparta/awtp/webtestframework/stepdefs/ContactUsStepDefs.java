package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.ContactUsPage;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class ContactUsStepDefs {
    private Website website;
    private ContactUsPage contactUsPage;
    private static final String CONTACT_US_PAGE_URL = "https://automationexercise.com/contact_us";
    private static final String SUCCESS_MESSAGE = "Success! Your details have been submitted successfully."; // Adjust this as needed


    @After
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }

    @Before
    public static void setup() throws Exception {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @Given("I am on the contact us page")
    public void iAmOnTheContactUsPage() {
        website = TestSetup.getWebsite(CONTACT_US_PAGE_URL);
        contactUsPage = website.getContactUsPage();
    }

    @Then("The the url should be that of the contact us page {string}")
    public void theTheUrlShouldBeThatOfTheContactUsPage(String expected_url) {
        Assertions.assertEquals(expected_url, CONTACT_US_PAGE_URL);
    }
}

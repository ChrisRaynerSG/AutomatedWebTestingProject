package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.ProductDetailPage;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReviewStepDefs {

    private static final String PRODUCT_DETAILS_URL = "https://automationexercise.com/product_details/1";
    private ProductDetailPage productDetailPage;

    @Given("I am on the product page")
    public void iAmOnTheProductPage() {
        Website website = TestSetup.getWebsite(PRODUCT_DETAILS_URL);
        productDetailPage = website.getProductDetailPage();
        productDetailPage.handleCookiesPopup();
    }

    @And("I enter a valid name and email")
    public void iEnterAValidNameAndEmail() {
        productDetailPage.enterName("test_user");
        productDetailPage.enterEmail("test_user@example.com");
    }

    @And("I enter a valid review")
    public void iEnterAValidReview() {
        productDetailPage.enterReview("Lorem ipsum dolor sit amet");
    }

    @Then("I see a message informing me the submission is successful")
    public void iSeeAMessageInformingMeTheSubmissionIsSuccessful() {
        assertThat(productDetailPage.getSuccessMessage(), is("Thank you for your review."));
    }

    @When("I click submit")
    public void iClickSubmit() {
        productDetailPage.clickSubmitButton();
    }
}

package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.AllProductsPage;
import com.sparta.awtp.webtestframework.pages.ProductDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class SearchStepDefs {

    private static final String ALL_PRODUCTS_URL = "https://automationexercise.com/products";
    private AllProductsPage allProductsPage;

    @Before("@search")
    public static void setup() throws Exception {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After("@search")
    public static void teardown() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }

    @Given("I am on the all products page")
    public void iAmOnTheAllProductsPage() {
        allProductsPage = TestSetup.getWebsite(ALL_PRODUCTS_URL).getAllProductsPage();
        allProductsPage.handleCookiesPopup();
    }

    @Then("I should see the product search bar")
    public void iShouldSeeTheProductSearchBar() {
        WebElement searchBar = allProductsPage.getSearchBar();
        Assertions.assertTrue(searchBar.isDisplayed());
    }
}

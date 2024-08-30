package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.AllProductsPage;
import com.sparta.awtp.webtestframework.pages.ProductDetailPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @When("I click the search button")
    public void iClickTheSearchButton() {
        allProductsPage.clickSearchButton();
    }

    @Then("I should see items in the shirts category")
    public void iShouldSeeItemsInTheCategory() {
        List<WebElement> searchResults = allProductsPage.getResultsItems();
        System.out.println(searchResults.getFirst().getText());
        Assertions.assertTrue(searchResults.getFirst().getText().contains("Tshirt"));
    }

    @And("I enter {string} in the search bar")
    public void iEnterInTheSearchBar(String searchQuery) {
        allProductsPage.search(searchQuery);
    }

    @Then("I should see items in the following categories:")
    public void iShouldSeeItemsInTheFollowingCategories(DataTable dataTable) {
        List<WebElement> returnedResults = allProductsPage.getResultsItems();
        List<String> categories = dataTable.asList(String.class);
        boolean found = false;
        for (WebElement result : returnedResults) {
            String text = result.getText();
            System.out.println(text);
            for (String category : categories) {
                System.out.println(category);
                if (text.contains(category)) {
                    found = true;
                    break;
                }
            }
        }
        Assertions.assertTrue(found);
    }

    @Then("I should see {string} in the search bar")
    public void iShouldSeeInTheSearchBar(String expected) {
        String text = allProductsPage.getValueEnteredIntoSearchBar();
        Assertions.assertEquals(expected, text);
    }

    @Then("I am on the {string} page")
    public void iAmOnThePage(String expected) {
        String currentUrl = TestSetup.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(expected, currentUrl);
    }
}

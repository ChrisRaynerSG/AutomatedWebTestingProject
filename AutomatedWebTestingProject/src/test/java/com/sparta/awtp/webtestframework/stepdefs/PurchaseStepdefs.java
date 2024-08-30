package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class PurchaseStepdefs {

    private Website website;

    @Before
    public void setup() throws IOException {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }

    @When("I click add to cart from products or home")
    public void iClickAddToCartFromProductsOrHome() {
        website.getHomePage().clickAddToCart();
    }
    @When("I click add to cart from item page")
    public void iClickAddToCartFromItemPage() {
        website.getItemPage().clickAddToCart();
    }

    @And("the item is in stock")
    public void theItemIsInStock() {
        //all items currently in stock
    }

    @Then("I should see my cart updated")
    public void iShouldSeeMyCartUpdated() {
        website.getHomePage().clickCartModalViewCart();
    }

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
    }

    @Given("I am on a specific items page")
    public void iAmOnASpecificItemsPage() {
        website = TestSetup.getWebsite(TestSetup.BASE_URL);
        website.getHomePage().clickConsentButton();
        website.getHomePage().clickViewProductButton();
    }

    @Given("I am on the view_cart page")
    public void iAmOnTheView_cartPage() {
    }

    @And("I have an item in my cart")
    public void iHaveAnItemInMyCart() {
    }

    @And("I am not logged in")
    public void iAmNotLoggedIn() {
    }

    @When("I click Proceed to checkout")
    public void iClickProceedToCheckout() {
    }

    @Then("I should be instructed to login or register")
    public void iShouldBeInstructedToLoginOrRegister() {
    }

    @And("I am logged in")
    public void iAmLoggedIn() {
    }

    @Then("I should be directed to the checkout page")
    public void iShouldBeDirectedToTheCheckoutPage() {
    }

    @And("my address details should be correct")
    public void myAddressDetailsShouldBeCorrect() {
    }

    @Given("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
    }

    @When("I click place order")
    public void iClickPlaceOrder() {
    }

    @Then("I should be directed to the payment page")
    public void iShouldBeDirectedToThePaymentPage() {
    }

    @Given("I am on the payment page")
    public void iAmOnThePaymentPage() {
    }

    @And("I have not input my card details")
    public void iHaveNotInputMyCardDetails() {
    }

    @When("I click pay and confirm order")
    public void iClickPayAndConfirmOrder() {
    }

    @Then("I should be informed what is missing")
    public void iShouldBeInformedWhatIsMissing() {
    }

    @And("remain on the payment page")
    public void remainOnThePaymentPage() {
    }

    @And("I have input my card details")
    public void iHaveInputMyCardDetails() {
    }

    @Then("I should be directed to the payment_done page")
    public void iShouldBeDirectedToThePayment_donePage() {
    }

    @And("be informed with the message {string}")
    public void beInformedWithTheMessage(String arg0) {
    }

    @And("I have items in my cart")
    public void iHaveItemsInMyCart() {
    }

    @Then("the correct number of items should be displayed")
    public void theCorrectNumberOfItemsShouldBeDisplayed() {
    }

    @And("the correct items should be displayed")
    public void theCorrectItemsShouldBeDisplayed() {
    }

    @When("I click remove item")
    public void iClickRemoveItem() {
    }

    @Then("the item should be removed from my cart")
    public void theItemShouldBeRemovedFromMyCart() {
    }
}

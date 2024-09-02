package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

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

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        website = TestSetup.getWebsite(TestSetup.BASE_URL);
        website.getHomePage().clickConsentButton();
    }

    @When("I click add to cart from products or home")
    public void iClickAddToCartFromProductsOrHome() throws InterruptedException {
        website = TestSetup.getWebsite(TestSetup.BASE_URL);
        website.getHomePage().clickConsentButton();
        website.getHomePage().clickAddToCart();
    }
    @When("I click add to cart from item page")
    public void iClickAddToCartFromItemPage() {
        website.getProductDetailPage().clickAddToCart();
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
        iAmOnTheHomepage();
        website.getHomePage().clickProductsPageButton();
    }

    @Given("I am on a specific items page")
    public void iAmOnASpecificItemsPage() {
        iAmOnTheHomepage();
        website.getHomePage().clickViewProductButton();
    }

    @Given("I am on the view_cart page")
    public void iAmOnTheView_cartPage() {
        iAmOnASpecificItemsPage();
        iClickAddToCartFromItemPage();
        website.getHomePage().clickContinueShopping();
        website.getProductDetailPage().clickViewCartButton();
    }

    @And("I have an item in my cart")
    public void iHaveAnItemInMyCart() {
        Assertions.assertFalse(website.getViewCartPage().getCartItems().isEmpty());
    }

    @And("I am not logged in")
    public void iAmNotLoggedIn() {
        Assertions.assertFalse(website.getViewCartPage().isUserSignedIn());
    }

    @When("I click Proceed to checkout")
    public void iClickProceedToCheckout() {
        website.getViewCartPage().clickCheckoutButton();
    }

    @Then("I should be instructed to login or register")
    public void iShouldBeInstructedToLoginOrRegister() {
        Assertions.assertTrue(website.getViewCartPage().isLoginModalVisible());
    }

    @Then("I should be directed to the checkout page")
    public void iShouldBeDirectedToTheCheckoutPage() {
        Assertions.assertEquals(TestSetup.BASE_URL + "checkout", TestSetup.getWebDriver().getCurrentUrl());
    }

    @And("^my address details should show (.+)$")
    public void myAddressDetailsShouldBeCorrect(String name) {
        Assertions.assertTrue(website.getCheckoutPage().listContainsName(name));
    }

    @Given("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        iAmOnASpecificItemsPage();
        iClickAddToCartFromItemPage();
        iAmLoggedInWithEmailAndPassword("abc2@abc2.abc","abc");
        iClickProceedToCheckout();
    }

    @When("I click place order")
    public void iClickPlaceOrder() {
        website.getCheckoutPage().clickPlaceOrderButton();
    }

    @Then("I should be directed to the payment page")
    public void iShouldBeDirectedToThePaymentPage() {
        Assertions.assertEquals(TestSetup.BASE_URL + "payment", TestSetup.getWebDriver().getCurrentUrl());
    }

    @Given("I am on the payment page")
    public void iAmOnThePaymentPage() {
        iAmOnTheCheckoutPage();
        website.getCheckoutPage().clickPlaceOrderButton();

    }

    @And("I have input the following card details:")
    public void inputCardDetails(DataTable cardDetailsTable) {
        List<Map<String,String>> cardDetailsList = cardDetailsTable.asMaps();
        for(Map<String, String> cardDetails : cardDetailsList) {
            website.getPaymentPage().enterCardName(cardDetails.get("Name"));
            website.getPaymentPage().enterCardNumber(cardDetails.get("CardNumber"));
            website.getPaymentPage().enterCardCvc(cardDetails.get("CVC"));
            website.getPaymentPage().enterExpiryDateMonth("ExpMonth");
            website.getPaymentPage().enterExpiryDateYear("ExpYear");
        }
    }
    @When("I click pay and confirm order")
    public void iClickPayAndConfirmOrder() throws InterruptedException {
        website.getPaymentPage().clickPayAndSubmitButton();
        Thread.sleep(Duration.ofSeconds(5));
    }

    @Then("I should be informed what is missing")
    public void iShouldBeInformedWhatIsMissing() {
        //not sure how to do this as cannot inspect field popup
    }

    @And("remain on the payment page")
    public void remainOnThePaymentPage() {
        Assertions.assertEquals(TestSetup.BASE_URL + "payment", TestSetup.getWebDriver().getCurrentUrl());
    }

    @Then("I should be directed to the payment_done page")
    public void iShouldBeDirectedToThePayment_donePage() {
        Assertions.assertEquals(TestSetup.BASE_URL + "payment_done/500", TestSetup.getWebDriver().getCurrentUrl());
    }

    @And("be informed with the message {string}")
    public void beInformedWithTheMessage(String message) {
        Assertions.assertTrue(website.getPaymentPage().getOrderConfirmation().contains(message));
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

    @And("^I am logged in with (.+) and (.+)$")
    public void iAmLoggedInWithEmailAndPassword(String email, String password) {
        website.getNavBarPage().clickSignupRegisterButton();
        website.getLoginPage().enterEmailLogin(email);
        website.getLoginPage().enterPasswordLogin(password);
        website.getLoginPage().clickLoginButton();
        website.getHomePage().clickViewCartButton();
    }

}

package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.WebDriver;

public class Website {

    private final WebDriver webDriver;
    private final LoginPage loginPage;
    private final SignupPage signupPage;
    private final ContactUsPage contactUsPage;
    private final ProductDetailPage productDetailPage;
    private final HomePage homePage;
    private final AccountCreatedPage accountCreatedPage;
    private final AllProductsPage allProductsPage;
    private final ViewCartPage viewCartPage;
    private final CheckoutPage checkoutPage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.loginPage = new LoginPage(webDriver);
        this.signupPage = new SignupPage(webDriver);
        this.contactUsPage = new ContactUsPage(webDriver);
        this.productDetailPage = new ProductDetailPage(webDriver);
        this.homePage = new HomePage(webDriver);
        this.accountCreatedPage = new AccountCreatedPage(webDriver);
        this.allProductsPage = new AllProductsPage(webDriver);
        this.viewCartPage = new ViewCartPage(webDriver);
        this.checkoutPage = new CheckoutPage(webDriver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }
    public ContactUsPage getContactUsPage(){
        return contactUsPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public AccountCreatedPage getAccountCreatedPage() {
        return accountCreatedPage;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public ProductDetailPage getProductDetailPage() {
        return productDetailPage;
    }

    public AllProductsPage getAllProductsPage() {
        return allProductsPage;
    }

    public ViewCartPage getViewCartPage() {
        return viewCartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }
}


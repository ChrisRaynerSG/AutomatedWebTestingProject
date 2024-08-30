package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.WebDriver;

public class Website {

    private final WebDriver webDriver;
    private final LoginPage loginPage;
    private final SignupPage signupPage;
    private final ProductDetailPage productDetailPage;
    private final HomePage homePage;
    private final AccountCreatedPage accountCreatedPage;
    private final AllProductsPage allProductsPage;
    private final ItemPage itemPage;
    private final ViewCartPage viewCartPage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.loginPage = new LoginPage(webDriver);
        this.signupPage = new SignupPage(webDriver);
        this.productDetailPage = new ProductDetailPage(webDriver);
        this.homePage = new HomePage(webDriver);
        this.accountCreatedPage = new AccountCreatedPage(webDriver);
        this.allProductsPage = new AllProductsPage(webDriver);
        this.itemPage = new ItemPage(webDriver);
        this.viewCartPage = new ViewCartPage(webDriver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
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

    public ItemPage getItemPage() {
        return itemPage;
    }

    public ViewCartPage getViewCartPage() {
        return viewCartPage;
    }
}


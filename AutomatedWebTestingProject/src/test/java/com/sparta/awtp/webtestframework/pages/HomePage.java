package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BannerFragmentPage {

    private final WebDriver webDriver;

    private final By consentButton = new By.ByClassName("fc-button-label");
    private final By itemElement = new By.ByCssSelector(".right:nth-child(4)");
    private final By addToCartPostBanner = new By.ByCssSelector(".col-sm-4:nth-child(3) .product-overlay .btn");
    private final By cartModal = new By.ById("cartModal");
    private final By cartModalContinue = new By.ByClassName("close-modal");
    private final By cartModalViewCart = new By.ByXPath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
    private final By viewCartButton = new By.ByClassName("view-cart-button");
    private final By viewProductButton = new By.ByClassName("choose");
    private final By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private final By productsPageButton = new By.ByXPath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private final By allProducts = new By.ByClassName("all-products");
    private final By logoutButton = By.linkText("Logout");

    public HomePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }

    public void clickConsentButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement consentButtonAppears = wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButtonAppears.click();
    }

    public void clickAddToCart() throws InterruptedException {
        Actions action = new Actions(webDriver);
        var allProductsElements = webDriver.findElements(By.className("single-products"));
        action.moveToElement(allProductsElements.getFirst()).perform();
        WebElement addToCart = webDriver.findElement(By.cssSelector(".col-sm-4:nth-child(3) .product-overlay .btn"));
        addToCart.click();
        Thread.sleep(Duration.ofSeconds(5));
//        var allProducts = webDriver.findElements(this.allProducts);
//        action.moveToElement(allProducts.getFirst()).perform();
//        webDriver.findElement(addToCartPostBanner).click();
//        Thread.sleep(Duration.ofSeconds(5));
    }

    public boolean isCartModalVisible(){
        return webDriver.findElement(cartModal).isDisplayed();
    }

    public void clickCartModalViewCart(){
        webDriver.findElement(cartModalViewCart).click();
    }

    public void clickViewProductButton(){
        webDriver.findElement(viewProductButton).click();
    }
    public void clickDeleteAccount() {
        WebElement deleteAccountElement = webDriver.findElement(deleteAccountButton);
        deleteAccountElement.click();
    }
    public void clickContinueShopping(){
        webDriver.findElement(cartModalContinue).click();
    }

    public void clickLogoutButton(){
        webDriver.findElement(logoutButton).click();
    }

    public boolean isDeleteAccountButtonVisible() {
        return webDriver.findElement(deleteAccountButton).isDisplayed();
    }
}

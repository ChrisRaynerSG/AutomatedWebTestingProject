package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver webDriver;

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

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void clickConsentButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement consentButtonAppears = wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButtonAppears.click();
    }

    public void clickAddToCart() {
        Actions action = new Actions(webDriver);
        WebElement addToCartPreBannerElement = webDriver.findElement(itemElement);
        action.moveToElement(addToCartPreBannerElement).perform();
        webDriver.findElement(addToCartPostBanner).click();
    }

    public boolean isCartModalVisible(){
        return webDriver.findElement(cartModal).isDisplayed();
    }

    public void clickContinueShopping(){
        webDriver.findElement(cartModalContinue).click();
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
    public void clickProductsPageButton() {
        webDriver.findElement(productsPageButton).click();
    }
}


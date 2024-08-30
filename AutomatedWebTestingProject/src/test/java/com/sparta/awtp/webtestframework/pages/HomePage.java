package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    private By consentButton = new By.ByClassName("fc-button-label");
    private By addToCartPreBanner = new By.ByXPath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
    private By addToCartPostBanner = new By.ByXPath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a");
    private By cartModal = new By.ById("cartModal");
    private By cartModalContinue = new By.ByClassName("close-modal");
    private By cartModalViewCart = new By.ByXPath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
    private By viewCartButton = new By.ByClassName("view-cart-button");
    private By viewProductButton = new By.ByClassName("choose");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConsentButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement consentButtonAppears = wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButtonAppears.click();
    }

    public void clickAddToCart() {
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartPreBannerElement = driver.findElement(addToCartPreBanner);
        action.moveToElement(addToCartPreBannerElement).perform();
        WebElement addToCartAppears = wait.until(ExpectedConditions.elementToBeClickable(addToCartPostBanner));
        addToCartAppears.click();
    }

    public boolean isCartModalVisible(){
        return driver.findElement(cartModal).isDisplayed();
    }

    public void clickContinueShopping(){
        driver.findElement(cartModalContinue).click();
    }

    public void clickCartModalViewCart(){
        driver.findElement(cartModalViewCart).click();
    }

    public void clickViewProductButton(){
        driver.findElement(viewProductButton).click();
    }

}

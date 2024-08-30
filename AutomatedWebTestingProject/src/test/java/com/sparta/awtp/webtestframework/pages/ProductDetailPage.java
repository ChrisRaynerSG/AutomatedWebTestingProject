package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {

    private final WebDriverWait wait;
    private final WebDriver webDriver;
    private final By cookiesPopupButton = By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button");
    private final By nameField = new By.ById("name");
    private final By emailField = new By.ById("email");
    private final By reviewField = new By.ById("review");
    private final By successMessage = new By.ById("review-section");
    private final By submitButton = new By.ById("button-review");
    private final By addToCart = new By.ByClassName("cart");

    public ProductDetailPage(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        this.webDriver = webDriver;
    }

    private WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void handleCookiesPopup() {
        WebElement cookiesButton = waitForElementToBeClickable(cookiesPopupButton);
        cookiesButton.click();
    }

    public boolean reviewSubmissionFormIsPresent() {
        WebElement nameElement = waitForElementToBeClickable(nameField);
        WebElement emailElement = waitForElementToBeClickable(emailField);
        WebElement reviewElement = waitForElementToBeClickable(reviewField);
        return nameElement.isDisplayed() && emailElement.isDisplayed() && reviewElement.isDisplayed();
    }

    public void enterName(String name) {
        WebElement nameElement = waitForElementToBeClickable(nameField);
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebElement emailElement = waitForElementToBeClickable(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterReview(String review) {
        WebElement reviewElement = waitForElementToBeClickable(reviewField);
        reviewElement.clear();
        reviewElement.sendKeys(review);
    }

    public String getSuccessMessage() {
        return webDriver.findElement(this.successMessage).getText();
    }

    public void clickSubmitButton() {
        WebElement submitButtonElement = waitForElementToBeClickable(submitButton);
        submitButtonElement.click();
    }
    public void clickAddToCart() {
        webDriver.findElement(addToCart).click();
    }
}

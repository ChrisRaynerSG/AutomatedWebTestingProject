package com.sparta.awtp.webtestframework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriverWait wait;
    private final By cookiesPopupButton = By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button");
    private final By nameField = By.name("name");
    private final By emailField = By.cssSelector("input[data-qa='signup-email']");
    private final By signUpButton = By.cssSelector("button[data-qa='signup-button']");
    private final By emailFieldLogin = By.cssSelector("input[data-qa='login-email']");
    private final By passwordFieldLogin = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");
    private final By errorMessage = By.cssSelector("p[style='color: red;']");

    public LoginPage(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void handleCookiesPopup() {
        WebElement cookiesButton = waitForElementToBeClickable(cookiesPopupButton);
        cookiesButton.click();
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

    public void clickSignUp() {
        WebElement signUpElement = waitForElementToBeClickable(signUpButton);
        signUpElement.click();
    }

    public void enterEmailLogin(String email) {
        WebElement emailElement = waitForElementToBeClickable(emailFieldLogin);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPasswordLogin(String password) {
        WebElement passwordElement = waitForElementToBeClickable(passwordFieldLogin);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = waitForElementToBeClickable(loginButton);
        loginButtonElement.click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).getText();
    }
}
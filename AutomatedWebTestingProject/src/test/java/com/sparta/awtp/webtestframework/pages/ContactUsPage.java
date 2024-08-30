package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private final By cookiesPopupButton = By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button");
    private final By nameField = By.name("name");
    private final By emailField = By.name("email");
    private final By subjectField = By.name("subject");
    private final By messageField = By.name("message");
    private final By uploadFileButton = By.name("upload_file");
    private final By submitButton = By.name("submit");
    private final By successMessage = By.cssSelector(".status");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement waitForElementToBeClickable(By locator) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
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

    public void enterSubject(String subject) {
        WebElement subjectElement = waitForElementToBeClickable(subjectField);
        subjectElement.clear();
        subjectElement.sendKeys(subject);
    }

    public void enterMessage(String message) {
        WebElement messageElement = waitForElementToBeClickable(messageField);
        messageElement.clear();
        messageElement.sendKeys(message);
    }

    public void clickUpload() {
        WebElement uploadElement = waitForElementToBeClickable(uploadFileButton);
        uploadElement.click();
        // Add code to upload a file, if necessary.
    }

    public void clickSubmit() {
        WebElement submitElement = waitForElementToBeClickable(submitButton);
        submitElement.click();

        // Wait for the alert to be present and accept it
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Wait for success message to be clickable after alert is accepted
        WebElement statusElement = waitForElementToBeClickable(successMessage);
        statusElement.click();
    }

    public String getSuccessMessage() {
        return waitForElementToBeClickable(successMessage).getText();
    }
}

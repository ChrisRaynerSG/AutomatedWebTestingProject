package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

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

    public void clickSubmitContactUs() {
        // Click the submit button first
        WebElement submitElement = waitForElementToBeClickable(submitButton);
        submitElement.click();

        // Handle any potential alerts after clicking the submit button
        try {
            // Wait for the alert to appear
            webDriverWait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert and accept it
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert detected with message: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("No alert appeared after clicking submit.");
        }

        // Now, handle the consent popup if it appears
        try {
            WebElement consentButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button")));
            consentButton.click();
            System.out.println("Consent button clicked.");
        } catch (TimeoutException e) {
            System.out.println("Consent button did not appear within the timeout period.");
        } catch (NoSuchElementException e) {
            System.out.println("Consent button not found.");
        }
    }

    public String getSuccessMessage() {
        return waitForElementToBeClickable(successMessage).getText();
    }

    public String getErrorPrompt(){
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement submitElement = waitForElementToBeClickable(submitButton);
        submitElement.click();
        System.out.println(emailField.getAttribute("validationMessage"));

        return emailField.getAttribute("validationMessage");
    }
}

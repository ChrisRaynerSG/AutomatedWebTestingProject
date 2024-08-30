package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private WebDriverWait webDriver;

    private final By nameField = By.name("name");
    private final By emailField = By.name("email");
    private final By subjectField = By.name("subject");
    private final By messageField = By.name("message");
    private final By uploadFileButton = By.name("upload_file");
    private final By submitButton = By.name("submit");

    public ContactUsPage(WebDriver webDriver){ this.webDriver = new WebDriverWait(webDriver, Duration.ofSeconds(10)); }

    private WebElement waitForElementToBeClickable(By locator) {
        return webDriver.until(ExpectedConditions.elementToBeClickable(locator));
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
        WebElement nameElement = waitForElementToBeClickable(subjectField);
        nameElement.clear();
        nameElement.sendKeys(subject);
    }
    public void enterMessage(String message) {
        WebElement nameElement = waitForElementToBeClickable(messageField);
        nameElement.clear();
        nameElement.sendKeys(message);
    }
    public void clickUpload() {
        WebElement signUpElement = waitForElementToBeClickable(uploadFileButton);
        signUpElement.click();
        //Add code to upload a file??
    }

    public void clickSubmit() {
        WebElement signUpElement = waitForElementToBeClickable(submitButton);
        signUpElement.click();
    }

}

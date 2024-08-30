package com.sparta.awtp.webtestframework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage {
    private final WebDriver webDriver;
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickContinue() {
        WebElement continueButtonElement = webDriver.findElement(continueButton);
        continueButtonElement.click();
    }
}
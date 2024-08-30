package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    private By consentButton = new By.ByClassName("fc-button-label");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConsentButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement consentButtonAppears = wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButtonAppears.click();
    }

}

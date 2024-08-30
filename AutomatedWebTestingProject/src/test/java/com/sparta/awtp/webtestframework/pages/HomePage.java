package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By consentButton = new By.ByClassName("fc-button-label");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConsentButton() {
        driver.findElement(consentButton).click();
    }

}

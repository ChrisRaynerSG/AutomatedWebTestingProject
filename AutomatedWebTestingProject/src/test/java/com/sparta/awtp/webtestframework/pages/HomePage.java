package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver webDriver;
    private final By deleteAccountButton = By.cssSelector("a[href='/delete_account']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickDeleteAccount() {
        WebElement deleteAccountElement = webDriver.findElement(deleteAccountButton);
        deleteAccountElement.click();
    }
}
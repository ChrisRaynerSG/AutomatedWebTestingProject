package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllProductsPage {

    private final WebDriverWait wait;
    private final WebDriver webDriver;
    private final By cookiesPopupButton = By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button");
    private final By searchBar = new By.ById("search_product");
    private final By resultItems = new By.ByClassName("productinfo");
    private final By searchButton = new By.ById("submit_search");

    public AllProductsPage(WebDriver webDriver) {
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

    public WebElement getSearchBar() {
        return waitForElementToBeClickable(searchBar);
    }

    public void search(String searchQuery) {
        getSearchBar().sendKeys(searchQuery);
    }

    public void clickSearchButton() {
        waitForElementToBeClickable(searchButton).click();
    }

    public List<WebElement> getResultsItems() {
        waitForElementToBeClickable(resultItems);
        return webDriver.findElements(resultItems);
    }

    public String getValueEnteredIntoSearchBar() {
        WebElement searchBar = getSearchBar();
        return searchBar.getAttribute("value");
    }
}

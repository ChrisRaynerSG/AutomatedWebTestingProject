package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.WebDriver;

public class Website {
    private WebDriver webDriver;
    private HomePage homePage;
    private ItemPage itemPage;
    private ViewCartPage viewCartPage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;
        homePage = new HomePage(webDriver);
        itemPage = new ItemPage(webDriver);
        viewCartPage = new ViewCartPage(webDriver);
    }
    public HomePage getHomePage() {
        return homePage;
    }
    public ItemPage getItemPage() {
        return itemPage;
    }
    public ViewCartPage getViewCartPage() {
        return viewCartPage;
    }
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
    public String getPageTitle() {
        return webDriver.getTitle();
    }

}

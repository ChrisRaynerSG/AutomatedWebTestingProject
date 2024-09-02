package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BannerFragmentPage {

    private final WebDriver driver;

    private final By viewCartButton = new By.ByXPath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    private final By productsPageButton = new By.ByXPath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");

    public BannerFragmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProductsPageButton() {
        driver.findElement(productsPageButton).click();
    }

    public void clickViewCartButton() {
        driver.findElement(viewCartButton).click();
    }

}

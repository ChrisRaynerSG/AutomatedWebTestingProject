package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {

    private WebDriver driver;
    private By addToCart = new By.ByClassName("cart");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToCart() {
        driver.findElement(addToCart).click();
    }

}

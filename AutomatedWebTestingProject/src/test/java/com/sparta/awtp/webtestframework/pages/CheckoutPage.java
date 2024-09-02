package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    private final WebDriver driver;

    private final By deliveryAddress = new By.ById("address_delivery");
    private final By placeOrderButton = new By.ByClassName("check_out");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean listContainsName(String deliveryAddress) {
        for(WebElement e : getDeliveryAddress()){
            if(e.getText().contains(deliveryAddress)){
                return true;
            }
        }
        return false;
    }

    private List<WebElement> getDeliveryAddress() {
        return driver.findElements(deliveryAddress);
    }
    public void clickPlaceOrderButton() {
        Actions action = new Actions(driver);
        action.scrollByAmount(1000,0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeOrderButtonAppears = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButtonAppears.click();
//        driver.findElement(placeOrderButton).click();
    }


}

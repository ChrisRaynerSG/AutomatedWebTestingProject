package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {

    private WebDriver driver;

    private By deliveryAddress = new By.ById("address_delivery");

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
}

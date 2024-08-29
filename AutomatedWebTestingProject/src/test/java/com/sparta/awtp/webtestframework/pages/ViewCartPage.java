package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewCartPage {

    private WebDriver driver;
    private By CartItemTable = new By.ById("cart_info_table");
    private By checkoutButton = new By.ByClassName("check_out");
    private By removeItemButton = new By.ByClassName("cart_delete");


    public ViewCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public List<WebElement> getCartItems(){
        return driver.findElements(CartItemTable);
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
    public void clickRemoveItemButton(){
        driver.findElement(removeItemButton).click();
    }
    public By getCartItem(String itemId){
        return By.id(itemId);
    }
    public String getItemDescription(String itemId){
        return driver.findElement(getCartItem(itemId)).getAttribute("cart_description");
    }

}

package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private WebDriver driver;
    private By nameField = new By.ByName("name_on_card");
    private By cardNumberField = new By.ByClassName("card-number");
    private By cardCvcField = new By.ByClassName("card-cvc");
    private By expiryDateMonthField = new By.ByClassName("card-expiry-month");
    private By expiryDateYearField = new By.ByClassName("card-expiry-year");
    private By payAndSubmitButton = new By.ById("submit");
    private By orderConfirmation = new By.ByClassName("col-sm-offset-1");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCardName(String cardName){
        if(cardName == null || cardName.isEmpty()){
            driver.findElement(nameField).sendKeys("");
        }
        else {
            driver.findElement(nameField).sendKeys(cardName);
        }
    }
    public void enterCardNumber(String cardNumber){
        if(cardNumber == null || cardNumber.isEmpty()){
            driver.findElement(cardNumberField).sendKeys("");
        }
        else {
            driver.findElement(cardNumberField).sendKeys(cardNumber);
        }
    }
    public void enterCardCvc(String cardCvc){
        if(cardCvc == null || cardCvc.isEmpty()){
            driver.findElement(cardCvcField).sendKeys("");
        }
        else {
            driver.findElement(cardCvcField).sendKeys(cardCvc);
        }
    }
    public void enterExpiryDateMonth(String expiryDateMonth){
        if(expiryDateMonth == null || expiryDateMonth.isEmpty()){
            driver.findElement(expiryDateMonthField).sendKeys("");
        }
        else {
            driver.findElement(expiryDateMonthField).sendKeys(expiryDateMonth);
        }
    }
    public void enterExpiryDateYear(String expiryDateYear){
        if(expiryDateYear == null || expiryDateYear.isEmpty()){
            driver.findElement(expiryDateYearField).sendKeys("");
        }
        else{
            driver.findElement(expiryDateYearField).sendKeys(expiryDateYear);
        }
    }
    public void clickPayAndSubmitButton(){
        driver.findElement(payAndSubmitButton).click();
    }
    public String getOrderConfirmation(){
        return driver.findElement(orderConfirmation).getText();
    }
}


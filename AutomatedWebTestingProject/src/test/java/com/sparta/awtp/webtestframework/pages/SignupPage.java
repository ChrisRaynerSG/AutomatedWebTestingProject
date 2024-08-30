package com.sparta.awtp.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    private final By titleMr = By.id("uniform-id_gender1");
    private final By titleMrs = By.id("id_gender2");
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By dobDay = By.id("days");
    private final By dobMonth = By.id("months");
    private final By dobYear = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By specialOffersCheckbox = By.id("optin");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countrySelect = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By submitButton = By.cssSelector("button[data-qa='create-account']");
    private final By successMessage = By.id("success_message"); // Adjust if needed

    public SignupPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(nameField)).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Element with id 'password' not found within the timeout period.");
            throw e;
        }
    }

    public void enterConfirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword);
    }

    public void enterDobDay(String dobDay) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(this.dobDay));
        element.sendKeys(dobDay);
    }

    public void enterDobMonth(String dobMonth) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(this.dobMonth));
        element.sendKeys(dobMonth);
    }

    public void enterDobYear(String dobYear) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(this.dobYear));
        element.sendKeys(dobYear);
    }

    public void setNewsletterSubscription(boolean subscribe) {
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(newsletterCheckbox));
        if (checkbox.isSelected() != subscribe) {
            checkbox.click();
        }
    }

    public void setSpecialOffers(boolean receiveOffers) {
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(specialOffersCheckbox));
        if (checkbox.isSelected() != receiveOffers) {
            checkbox.click();
        }
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameField)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameField)).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        wait.until(ExpectedConditions.presenceOfElementLocated(companyField)).sendKeys(company);
    }

    public void enterAddress1(String address1) {
        wait.until(ExpectedConditions.presenceOfElementLocated(address1Field)).sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        wait.until(ExpectedConditions.presenceOfElementLocated(address2Field)).sendKeys(address2);
    }

    public void enterCountry(String country) {
        WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(countrySelect));
        selectElement.sendKeys(country);
    }

    public void enterState(String state) {
        wait.until(ExpectedConditions.presenceOfElementLocated(stateField)).sendKeys(state);
    }

    public void enterCity(String city) {
        wait.until(ExpectedConditions.presenceOfElementLocated(cityField)).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        wait.until(ExpectedConditions.presenceOfElementLocated(zipcodeField)).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mobileNumberField)).sendKeys(mobileNumber);
    }

    public void submitRegistrationForm() {
        try {
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            submitBtn.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            System.out.println("Submit button click intercepted. Attempting to handle the blockage.");

            try {
                WebElement closeButton = webDriver.findElement(By.cssSelector("button.close"));
                if (closeButton.isDisplayed()) {
                    closeButton.click();
                    System.out.println("Blocking element closed.");
                }
            } catch (org.openqa.selenium.NoSuchElementException nse) {
                System.out.println("No blocking element found. Retrying the submit.");
            }
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
            submitBtn.click();
        }
    }

    public boolean isSignupFormDisplayed() {
        return !webDriver.findElements(submitButton).isEmpty();
    }
}
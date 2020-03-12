package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Set password value to the implicitly declared variable
     * @param element
     * @param userInput
     */
    public void setUserInput(WebElement element, String userInput){
        element.sendKeys(userInput);
    }

    /**
     * Click the button
     * @param element
     */
    public void clickButton(WebElement element){
        element.click();
    }
}

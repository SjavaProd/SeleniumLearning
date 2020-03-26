package com.base;

import org.apache.poi.ss.formula.functions.WeekdayFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public WebDriver driver;
    //public Wait<WebDriver> webDriverWait = new WebDriverWait(driver, 5, 1000);
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * Set user`s input to the implicitly declared variable
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
    public void mouseClick(WebElement element){
        element.click();
    }

    /**
     * Mouseover the element
     * @param element
     */
    public void mouseOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

}

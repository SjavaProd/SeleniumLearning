package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Set id value to the implicitly declared variable
     * @param userID
     * @param strID
     */
    public void setUserID(WebElement userID, String strID) {
        userID.sendKeys(strID);
    }

    /**
     * Set password value to the implicitly declared variable
     * @param userPassword
     * @param strPassword
     */
    public void setUserPassword(WebElement userPassword, String strPassword){
        userPassword.sendKeys(strPassword);
    }

    /**
     * Click the "Login" button
     * @param loginSubmit
     */
    public void submitForm(WebElement loginSubmit){
        loginSubmit.click();
    }
}

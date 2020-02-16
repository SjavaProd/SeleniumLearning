package com.base;

import com.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class BasePage extends LoginPage {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void setUserID(String strID) {
        userID.sendKeys(strID);
    }

    //Set password to field
    public void setUserPassword(String strPassword){
        userPassword.sendKeys(strPassword);
    }

    //Click Submit button
    public void submitForm(){
        loginSubmit.click();
    }

    /**
     * Submit form with all required params
     * @param strID
     * @param strPassword
     */
    public void loginToSite(String strID, String strPassword){
        this.setUserID(strID);
        this.setUserPassword(strPassword);
        this.submitForm();
    }
}

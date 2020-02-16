package com.page;

import com.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    /**
     * All WebElements are identified by @FindBy annotation
     */
    public WebDriver driver;
    @FindBy(name = "uid")
    public WebElement userID;
    //By userID = By.name("uid");
    @FindBy(name = "password")
    public WebElement userPassword;
    //By userPassword = By.name("password");
    @FindBy(name = "btnLogin")
    public WebElement loginSubmit;
    //By loginSubmit = By.name("btnLogin");

    //Constructor for class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Set username to field
    /*public void setUserID(String strID) {
        userID.sendKeys(strID);
        //driver.findElement(userID).sendKeys(strID);
    }

    //Set password to field
    public void setUserPassword(String strPassword){
        userPassword.sendKeys(strPassword);
    }

    //Click Submit button
    public void submitForm(){
        loginSubmit.click();
    }*/

    /**
     * Submit form with all required params
     * @param strID
     * @param strPassword
     */
    /*public void loginToSite(String strID, String strPassword){
        this.setUserID(strID);
        this.setUserPassword(strPassword);
        this.submitForm();
    }*/
}

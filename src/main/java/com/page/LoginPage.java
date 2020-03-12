package com.page;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    /**
     * Constructor for the class with using PageObjects
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * All WebElements are identified by @FindBy annotation
     */
    @FindBy(name = "uid")
    public WebElement userID;
    @FindBy(name = "password")
    public WebElement userPassword;
    @FindBy(name = "btnLogin")
    public WebElement loginButton;

    /**
     * Submit form with all required params
     * setUserInput method is predefined in the parrent class
     * @param strID
     * @param strPassword
     */
    public void loginToSite(String strID, String strPassword){
        setUserInput(userID, strID);
        setUserInput(userPassword, strPassword);
        clickButton(loginButton);
    }

}

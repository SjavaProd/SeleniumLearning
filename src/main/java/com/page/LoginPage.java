package com.page;

import com.base.BasePage;
import com.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    //Constructor for class
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
    public WebElement loginSubmit;

    @Override
    public void setUserID(String strID) {
        this.userID.sendKeys(strID);
    }

    @Override
    public void setUserPassword(String strPassword) {
        this.userPassword.sendKeys(strPassword);
    }

    @Override
    public void submitForm() {
        this.loginSubmit.click();
    }
}

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
    @FindBy(name = "password")
    public WebElement userPassword;
    @FindBy(name = "btnLogin")
    public WebElement loginSubmit;

    //Constructor for class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}

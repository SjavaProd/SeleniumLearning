package com.page;

import com.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HerokuSite extends BasePage {

    public HerokuSite(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "A/B Testing")
    private WebElement abTestLink;
    @FindBy(css = "#content > div > h3")
    private WebElement abTestHeader;

    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveLink;
    @FindBy(css = "#content > div > button")
    private WebElement addButton;
    @FindBy(css = "#elements > button:nth-child(2)")
    private WebElement deleteButton;

    @FindBy(css = "#content > div > p")
    private WebElement successAuth;

    @FindBy(linkText = "Broken Images")
    private WebElement brokenImagesLink;
    @FindBy(tagName = "img")
    private List<WebElement> listOfImages;

    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxesLink;
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    private WebElement checkbox1;
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    private WebElement checkbox2;

    @FindBy(linkText = "Context Menu")
    private WebElement contextMenuLink;
    @FindBy(id = "hot-spot")
    private WebElement hotSpotArea;

    @FindBy(linkText = "Disappearing Elements")
    private WebElement disElementsLink;
    @FindBy (tagName = "a")
    private List <WebElement> existingElements;

    @FindBy (linkText = "Drag and Drop")
    private WebElement dragAndDropLink;
    @FindBy (id = "column-a")
    private WebElement firstColumn;
    @FindBy (id = "column-a")
    private WebElement secondColumn;

    @FindBy (linkText = "Dropdown")
    private WebElement dropDownLink;
    @FindBy (xpath = "//*[@id=\"dropdown\"]")
    private WebElement dropDownList;

    @FindBy (linkText = "Dynamic Controls")
    private WebElement dynamicControlsLink;
    @FindBy (id = "checkbox")
    private WebElement checkboxDynamic;
    @FindBy (xpath = "//*[@id=\"checkbox-example\"]/button")
    private WebElement removeButton;
    @FindBy (xpath = "//*[@id=\"message\"]")
    private WebElement message;
    @FindBy (xpath = "//*[@id=\"input-example\"]/input")
    private WebElement inputField;
    @FindBy (xpath = "//*[@id=\"input-example\"]/button")
    private WebElement enableButton;
    @FindBy (id = "message")
    private  WebElement inputIsAvailableMessage;

    @FindBy (linkText = "Entry Ad")
    private WebElement entryAdLink;
    @FindBy (css = "#modal > div.modal > div.modal-title")
    private WebElement modalTitle;
    @FindBy (xpath = "//*[@id=\"modal\"]/div[2]/div[3]/p")
    private WebElement modalCloseButton;
    @FindBy (linkText = "click here")
    private WebElement restartAdButton;

    @FindBy (linkText = "JavaScript Alerts")
    private WebElement javaScriptAlertsLink;
    @FindBy (css = "#content > div > ul > li:nth-child(1) > button")
    private WebElement jsAlertButton;
    @FindBy (css = "#content > div > ul > li:nth-child(2) > button")
    private WebElement jsConfirmButton;
    @FindBy (css = "#content > div > ul > li:nth-child(3) > button")
    private WebElement jsPromptButton;
    @FindBy (id = "result")
    private WebElement resultText;

    @FindBy (linkText = "Horizontal Slider")
    private WebElement sliderLink;
    @FindBy (css = "#content > div > div > input[type=range]")
    private WebElement slider;
    @FindBy (id = "range")
    private WebElement rangeValue;

    @FindBy (linkText = "Key Presses")
    private WebElement keyPressesLink;
    @FindBy (id = "target")
    private WebElement inputFieldForKey;
    @FindBy (id = "result")
    private WebElement resultForKey;

    @FindBy (linkText = "Multiple Windows")
    private WebElement multipleWindowsLink;
    @FindBy (css = "#content > div > h3")
    private WebElement firstPageTitle;
    @FindBy (css = "#content > div > a")
    private WebElement clickHereButton;

    @FindBy (linkText = "Nested Frames")
    private WebElement frameLink;
    /*@FindBy(name = "frame-middle")
    private WebElement middleFrame;*/
    @FindBy (id = "content")
    private WebElement frameText;



    public void abTesting() {
        mouseClick(abTestLink);
        System.out.println(getElementText(abTestHeader));
        backToPreviousPage();
    }

    public void addRemoveElements() {
        mouseClick(addRemoveLink);
        mouseClick(addButton);
        mouseClick(addButton);
        mouseClick(deleteButton);
        System.out.println("Elements are added and removed");
        backToPreviousPage();
    }

    public void basicAuthTest() {
        navigateToSite("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        System.out.println(getElementText(successAuth));
        backToPreviousPage();
    }

    public void testBrokenImages() throws IOException {
        mouseClick(brokenImagesLink);
        System.out.println("Quantity of all images on the page: " + listOfImages.size());
        List<String> brokenImgURL = new ArrayList<String>();
        for (int i = 0; i < listOfImages.size(); i++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(listOfImages.get(i).getAttribute("src")).openConnection();
            connection.connect();
            int brokenImagesResponseCode = connection.getResponseCode();
            connection.disconnect();
            if (brokenImagesResponseCode == 404) {
                brokenImgURL.add(listOfImages.get(i).getText());
                System.out.println("Broken IMG URL: " + connection.getURL());
            }
        }
        System.out.println("We have " + brokenImgURL.size() + " broken images");
        backToPreviousPage();
    }

    public void testCheckboxes() {
        mouseClick(checkboxesLink);
        mouseClick(checkbox1);
        mouseClick(checkbox2);
        System.out.println("All checkboxes are clicked");
        backToPreviousPage();
    }

    public void testContextMenu() {
        mouseClick(contextMenuLink);
        mouseRightClick(hotSpotArea);
        submitAlert();
        waitForElementIsVisible(hotSpotArea);
        backToPreviousPage();
    }

    public void testDisappearingElements() {
        mouseClick(disElementsLink);
        while (existingElements.size()!=7){
            System.out.println("Page is reloading while the element is not displayed");
            reloadPage();
        }
        backToPreviousPage();
    }

    public void testDragAndDropElements() {
        mouseClick(dragAndDropLink);
        dragAndDrop(firstColumn, secondColumn);
        backToPreviousPage();
    }

    public void testDropDown(int dropDownIndex){
        mouseClick(dropDownLink);
        selectFromDropDown(dropDownList, dropDownIndex);
        backToPreviousPage();
    }

    public void testDynamicControls (){
        mouseClick(dynamicControlsLink);
        mouseClick(checkboxDynamic);
        mouseClick(removeButton);
        waitForElementIsVisible(message);
        System.out.println("The \"It's gone!\" message is displayed: " + elementContainsFollowingText(message, "It's gone!"));
        mouseClick(removeButton);
        waitForElementIsVisible(message);
        System.out.println("The \"It's back!\" message is displayed: " + elementContainsFollowingText(message, "It's back!"));
        mouseClick(enableButton);
        waitForElementIsClickable(inputField);
        System.out.println("The \"It's enabled!\" message is displayed: " + elementContainsFollowingText(message, "It's enabled!"));
        backToPreviousPage();
    }

    public void testEntryAd (){
        mouseClick(entryAdLink);
        waitForElementIsClickable(modalCloseButton);
        mouseClick(modalCloseButton);
        waitForElementIsClickable(restartAdButton);
        backToPreviousPage();
    }

    public void testJSAlerts(String userInput){
        mouseClick(javaScriptAlertsLink);
        mouseClick(jsAlertButton);
        submitAlert();
        waitForElementIsVisible(resultText);
        System.out.println("Alert is submitted: " + elementContainsFollowingText(resultText, "You successfuly clicked an alert"));
        waitForElementIsClickable(jsPromptButton);
        mouseClick(jsPromptButton);
        sendDataToAlert(userInput);
        submitAlert();
        waitForElementIsVisible(resultText);
        System.out.println("Alert is submitted with next data: " + userInput + " - "
                + elementContainsFollowingText(resultText, "You entered: Test for Slava"));
        mouseClick(jsConfirmButton);
        submitAlert();
        waitForElementIsVisible(resultText);
        System.out.println("Alert is submitted: " + elementContainsFollowingText(resultText, "You clicked: Ok"));
        mouseClick(jsConfirmButton);
        dismissAlert();
        waitForElementIsVisible(resultText);
        System.out.println("Alert is dismissed: " + elementContainsFollowingText(resultText, "You clicked: Cancel"));
        backToPreviousPage();
    }

    public void testHorizontalSlider (int position) {
        mouseClick(sliderLink);
        moveSlider(slider, position);
        System.out.println("Quantity of steps: " + getElementText(rangeValue));
        backToPreviousPage();
    }

    public void testKeyPresses(Keys key){
        mouseClick(keyPressesLink);
        waitForElementIsClickable(inputFieldForKey);
        keyPress(inputFieldForKey, key);
        waitForElementIsVisible(resultForKey);
        System.out.println("You entered: " + key + elementContainsFollowingText(resultForKey, "You entered: SPACE"));
        backToPreviousPage();
    }

    public void testNavigationBetweenTabs(){
        mouseClick(multipleWindowsLink);
        mouseClick(clickHereButton);
        navigateToPreviousTab();
        waitForElementIsVisible(firstPageTitle);
        System.out.println("The title of the first page is \"Opening a new window\": " + elementContainsFollowingText(firstPageTitle, "Opening a new window"));
        backToPreviousPage();
    }

    public void testChangeFrame(){
        mouseClick(frameLink);
        switchFrame(0);
        switchFrame(1);
        System.out.println(getElementText(frameText));
    }

}

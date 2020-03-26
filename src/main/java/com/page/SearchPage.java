package com.page;
/**
 * Реализовать следующий сценарий: поиск по интернет магазину (нужно чтобы возвращал 5-10 результатов)
 * и вывести в консоль сумму цен прродуктов которые больтше заданного числа.
 * (например после поиска тебе приходит 10 продуктов с разными ценами - 5,10,15,20,50 долларов .
 * Тебе нужно посчитать сумму всех продуктов у которых цена меньше 20 долларов).
 * Цель - научиться использовать коллекции, циклы и перебор по коллекции в разрезе веба
 */

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "Electronics")
    public WebElement category;
    @FindBy (linkText = "Computers & Tablets")
    public WebElement subcategory;
    @FindBy (linkText = "Computer Components & Parts")
    public WebElement subcategory1;
    @FindBy (linkText = "Graphics/Video Cards")
    public WebElement subcategory2;
    @FindBy (css = "#w2-w1-w0-w0-w1 > button")
    public WebElement advancedSearchWindow;
    @FindBy (id = "refineOverlay-subPanel-Brand_ZOTAC_cbx")
    public WebElement brandSelection;
    @FindBy (id = "refineOverlay-mainPanel-price")
    public WebElement priceSelection;
    @FindBy (id = "refineOverlay-subPanel-_x-price-0-1[0]")
    public WebElement maxPrice;
    @FindBy (id = "refineOverlay-mainPanel-Memory%20Size")
    public WebElement memorySizeSelector;
    @FindBy (id = "refineOverlay-subPanel-Memory%20Size_8%20GB_cbx")
    public WebElement memorySize;
    @FindBy (css = "#refineOverlay-footerId > div.x-overlay-footer__apply > button")
    public WebElement applyButton;
    @FindBy (className = "s-item__price")
    public List<WebElement> priceValue;

    public void proceedToSearch(){
        mouseOver(category);
        mouseClick(subcategory);
        mouseClick(subcategory1);
        mouseClick(subcategory2);
    }

    public void setupFilters(String value){
        mouseClick(advancedSearchWindow);
        mouseClick(brandSelection);
        mouseClick(priceSelection);
        setUserInput(maxPrice, value);
        mouseClick(memorySizeSelector);
        mouseClick(memorySize);
        mouseClick(applyButton);
    }

    public void calculatePriceOfMatchedItems(){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#w7-w0 > div:nth-child(2) > div > div > h2")));
        double totalPrice = 0;
        int counterOfMatchedItems = 0;
        for (int i = 0; i < priceValue.size(); i++) {
            Pattern pattern = Pattern.compile("\\d.+\\d");
            Matcher matcher = pattern.matcher(priceValue.get(i).getText());
            double price = 0;
            while (matcher.find()) {
                price = Double.parseDouble(priceValue.get(i).getText().substring(matcher.start(), matcher.end()));
            }
            if (price < 20) {
                System.out.println("Price of the matched item: " + price);
                totalPrice += price;
                counterOfMatchedItems++;
            }
        }
        System.out.println("Quantity of all matched items: " + counterOfMatchedItems);
        System.out.println("Total price of all matched items: " + Math.round(totalPrice));
    }
}

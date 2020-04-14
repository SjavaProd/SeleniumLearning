package com.page;
/**
 * Реализовать следующий сценарий: поиск по интернет магазину (нужно чтобы возвращал 5-10 результатов)
 * и вывести в консоль сумму цен прродуктов которые больтше заданного числа.
 * (например после поиска тебе приходит 10 продуктов с разными ценами - 5,10,15,20,50 долларов .
 * Тебе нужно посчитать сумму всех продуктов у которых цена меньше 20 долларов).
 * Цель - научиться использовать коллекции, циклы и перебор по коллекции в разрезе веба
 */

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "Electronics")
    private WebElement electronicsCategory;
    @FindBy (linkText = "Computers & Tablets")
    private WebElement computersSubcategory;
    @FindBy (linkText = "Computer Components & Parts")
    private WebElement componentsSubcategory;
    @FindBy (linkText = "Graphics/Video Cards")
    private WebElement graphicsSubcategory;

    @FindBy (css = "#s0-28-13_2-0-1\\[1\\]-0-6-2 > button")
    private WebElement advancedSearchButton;
    @FindBy (id = "c3-mainPanel-Brand")
    private WebElement brandSelector;
    @FindBy (css = "#c3-subPanel-Brand_ZOTAC > label")
    private WebElement zotacBrand;

    @FindBy (id = "c3-subPanel-_x-price-textrange")
    private WebElement label;

    @FindBy (id = "c3-mainPanel-price")
    private WebElement priceSelector;
    @FindBy (xpath = "//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[2]/div/input")
    private WebElement maxPrice;
    @FindBy (id = "c3-mainPanel-Memory%20Size")
    private WebElement memorySizeSelector;
    @FindBy (id = "c3-subPanel-Memory%20Size_8%20GB_cbx")
    private WebElement memorySizeValue8gb;
    @FindBy (id = "c3-subPanel-Memory%20Size_6%20GB_cbx")
    private WebElement memorySizeValue6gb;
    @FindBy (id = "c3-subPanel-Memory%20Size_4%20GB_cbx")
    private WebElement memorySizeValue4gb;
    @FindBy (xpath = "//*[@id=\"c3-footerId\"]/div[2]/button")
    private WebElement applyButton;

    @FindBy (className = "s-item__price")
    private List<WebElement> priceValue;
    @FindBy (xpath = "//*[@id=\"s0-25-9-0-1[0]-0-1-6-5\"]/div[2]/div/div/h2")
    private WebElement quantity;

    public void proceedToSearch(){
        mouseOver(electronicsCategory);
        mouseClick(computersSubcategory);
        mouseClick(componentsSubcategory);
        mouseClick(graphicsSubcategory);
    }

    public void setupFilters(String value){
        scrollToElement(advancedSearchButton);
        mouseClick(advancedSearchButton);
        mouseClick(brandSelector);
        mouseClick(zotacBrand);
        mouseClick(priceSelector);
        waitForElementIsClickable(maxPrice);
        setUserInput(maxPrice, value);
        mouseClick(memorySizeSelector);
        mouseClick(memorySizeValue8gb);
        //waitForClick(memorySizeValue6gb);
        //mouseClick(memorySizeValue6gb);
        waitForElementIsClickable(memorySizeValue4gb);
        mouseClick(memorySizeValue4gb);
        mouseClick(applyButton);
    }

    public void calculatePriceOfMatchedItems(){
        waitForElementIsVisible(quantity);
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

import com.base.BaseTest;
import com.page.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPriceForItems extends BaseTest{

    @Test
    public void workWithDifferentElements() {

        WebDriver driver = BaseTest.getDriver();
        driver.get("https://www.ebay.com/");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.proceedToSearch();
        searchPage.setupFilters("50");
        searchPage.calculatePriceOfMatchedItems();
    }
}

import com.base.BaseTest;
import com.page.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestPriceForItems extends BaseTest{

    @Test
    public void searchMatchedItems() {

        WebDriver driver = BaseTest.getDriver();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.navigateToSite("https://www.ebay.com/");
        searchPage.proceedToSearch();
        searchPage.setupFilters("50");
        searchPage.calculatePriceOfMatchedItems();
    }
}

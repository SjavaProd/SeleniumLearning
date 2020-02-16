import com.base.BasePage;
import com.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    BasePage loginPageTest;

    @Test
    public void testLoginPage(){
        WebDriver driver = BaseTest.getDriver();
        driver.get("http://demo.guru99.com/V4/");
        loginPageTest = new BasePage(driver);
        loginPageTest.loginToSite("mngr246436", "rEgezen");
        String expectedID = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
        Assert.assertTrue(expectedID.contains("Manger Id : mngr246436"));
    }
}

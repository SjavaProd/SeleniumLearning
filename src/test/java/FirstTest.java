import com.base.BaseTest;
import com.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    LoginPage loginPageTest;

    @Test
    public void testLoginPage(){
        WebDriver driver = BaseTest.getDriver();
        driver.get("http://demo.guru99.com/V4/");
        loginPageTest = new LoginPage(driver);
        loginPageTest.loginToSite("mngr249880", "vurAhyz");
        String expectedID = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
        Assert.assertTrue(expectedID.contains("Manger Id : mngr249880"));
    }
}

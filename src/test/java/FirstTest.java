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

        /*The following path to the required element (expectedID) can be found by the:
        absolute XPath: /html/body/table/tbody/tr/td/table/tbody/tr[3]/td;
        relative XPath: //body//tr[3];
        CSS Path: html body table.layout tbody tr td table tbody tr.heading3 td;
        CSS selector: tr.heading3 > td:nth-child(1)
         */
        String expectedID = driver.findElement(By.cssSelector("tr.heading3 > td:nth-child(1)")).getText();
        Assert.assertTrue(expectedID.contains("Manger Id : mngr249880"));
    }
}
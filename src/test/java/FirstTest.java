import com.base.BaseTest;
import com.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    @Test
    public void testLoginPage(){
        WebDriver driver = BaseTest.getDriver();
        LoginPage loginPageTest = new LoginPage(driver);
        loginPageTest.navigateToSite("http://demo.guru99.com/V4/");
        loginPageTest.loginToSite("mngr255084", "AhUparU");
        String expectedID = loginPageTest.getElementText();
        Assert.assertTrue(expectedID.contains("Manger Id : mngr255084"));
    }
}
import com.base.BaseTest;
import com.page.HerokuSite;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class HerokuTest extends BaseTest {

    @Test
    public void herokuSiteTesting () throws IOException {

        WebDriver driver = BaseTest.getDriver();
        HerokuSite herokuSite = new HerokuSite(driver);
        herokuSite.navigateToSite("http://the-internet.herokuapp.com/");
        herokuSite.abTesting();
        herokuSite.addRemoveElements();
        herokuSite.basicAuthTest();
        herokuSite.testBrokenImages();
        herokuSite.testCheckboxes();
        herokuSite.testContextMenu();
        herokuSite.testDisappearingElements();
        herokuSite.testDragAndDropElements();
        herokuSite.testDropDown(1);
        herokuSite.testDynamicControls();
        herokuSite.testEntryAd();
        herokuSite.testJSAlerts("Test for Slava");
        herokuSite.testHorizontalSlider(60);
        herokuSite.testKeyPresses(Keys.SPACE);
        herokuSite.testNavigationBetweenTabs();
        herokuSite.testChangeFrame();
    }

}

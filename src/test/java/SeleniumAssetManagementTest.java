import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by FelixBrass on 05.03.2015.
 *
 * RUN "nodeTestServer.js" IN NODE FIRST!!!!
 */
public class SeleniumAssetManagementTest  {

    private WebDriver driver;

    @Before
    public void setUp(){
        this.driver= new FirefoxDriver();
        driver.get("localhost:8080");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testingWebsiteload(){
        assertEquals("Asset Management AngularJS App", driver.getTitle());
    }

    @Test
    public void testingloadAssetTypes(){
        WebElement table = getWhenVisible(driver, By.className("asset-types-items"),10);
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        assertFalse(tableRows.size()==6);
    }

    @Test
    public void testingAssets(){
        changeSite(driver,"Assets",10);
        WebElement assetList = getWhenVisible(driver, By.className("asset-list"), 10);
        List<WebElement> assets = assetList.findElements(By.tagName("li"));
        assertTrue(assets.size() == 29);
    }

    @Test
    public void testingAssetListedByAssetType(){
        WebElement table= getWhenVisible(driver, By.className("asset-types-items"), 10);
        List<WebElement> tableRows= table.findElements(By.tagName("tr"));
        tableRows.get(1).findElement(By.tagName("a")).click();
        WebElement assetList = getWhenVisible(driver, By.className("asset-list"), 10);
        List<WebElement> assets = assetList.findElements(By.tagName("li"));
        assertTrue(assets.size()==5);
    }

    @Test
    public void testingAssetSearch(){
        changeSite(driver,"Assets",10);
        WebElement inputGroup= getWhenVisible(driver, By.className("input-group"), 10);
        WebElement inputField = inputGroup.findElement(By.tagName("input"));
        inputField.sendKeys("SPQR");
        WebElement assetList = getWhenVisible(driver, By.className("asset-list"), 10);
        List<WebElement> assets = assetList.findElements(By.tagName("li"));
        assertTrue(assets.size()==1);
    }

    @Test
    public void testAssetEdit(){
        changeSite(driver,"Assets",10);
        WebElement assetList = getWhenVisible(driver, By.className("asset-list"), 10);
        WebElement link = assetList.findElement(By.linkText("SPQR Asset Management Tool 7.2"));
        link.click();
        WebElement assetName = getWhenVisible(driver, By.className("legend-container"),10);
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        assertTrue(labels.get(labels.size()-1).getText().equals("Currency:"));
    }


    private static void changeSite(final WebDriver driver,final String linkText, final int time){
        WebElement link =getWhenVisible(driver,By.linkText(linkText),time);
        link.click();
    }

    private static WebElement getWhenVisible(final WebDriver driver, final By locator, final int time){
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, time);
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
}

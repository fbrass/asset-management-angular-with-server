import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Felix on 05.03.2015.
 */
public class SeleniumAssetManagementTest  {

    @Test
    public void testingOpenBrowser(){
        WebDriver driver = new FirefoxDriver();
        driver.get("localhost:8080");
        System.out.println();

    }
}

package entrata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ValidatePropertyManagementSectionLinksOfProductsTabIT {

    /**
     *  This test will verify all the links of Property Management section of the Products tab are working or not.
     * @throws IOException
     */

    @Test
    public void validateAllLinksOfPropertyManagementSectionOfTheProductsTab() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.entrata.com/");

        //Verifying actual page title with expected page title of the 'entrata.com'
        String expectedPageTitle = "Property Management Software | Entrata";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        Actions actions = new Actions(driver);

        WebElement productsTab = driver.findElement(By.xpath("//div[contains(text(),'Products')]"));
        actions.moveToElement(productsTab).perform();

        WebElement propertyManagementSection = driver.findElement(By.xpath("(//div[@class='nav-group'])[1]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(propertyManagementSection));

        // String array contains expected urls
        String[] expectedSubTabUrl = {"https://www.entrata.com/products/property-management",
                "https://www.entrata.com/products/residentpay",
                "https://www.entrata.com/products/residentportal",
                "https://www.entrata.com/products/BI",
                "https://www.entrata.com/products/revenue-management",
                "https://www.entrata.com/products/srm",
                "https://www.entrata.com/products/access-connect",
                "https://www.entrata.com/products/message-center",
                "https://www.entrata.com/products/facility-management",
                "https://www.entrata.com/products/reporting",
                "https://www.entrata.com/products/sitetablet"};

        //Following step will find all the links of Property Management tab
        List<WebElement> subLinksOfManagementSection = propertyManagementSection.findElements(By.tagName("a"));

        //This block of code will check every link is working or not by opening its connection at backend
        int i=0;
        for (WebElement link : subLinksOfManagementSection) {

            String urlLink = link.getAttribute("href");

            URL url = new URL(urlLink);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();

            String currentUrl = httpURLConnection.getURL().toString();
            Assert.assertEquals(currentUrl, expectedSubTabUrl[i]);
            i++;
        }
        driver.quit();
    }
}

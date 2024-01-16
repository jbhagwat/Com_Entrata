package entrata;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyAvailableResourcesOfResourcesTabIT {

    /**
     * This test is to verify the available resources of the 'Resources' tab
     * Redirect to individual resource guide page and verify
     * @throws InterruptedException
     */
    @Test
    public void verifyAllResourcesOfResourcesTab() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.entrata.com/");

        WebElement resourcesTab = driver.findElement(By.linkText("Resources"));
        resourcesTab.click();
        String expectedResourcesTabUrl = "https://www.entrata.com/";
        Assert.assertTrue(expectedResourcesTabUrl.equals(driver.getCurrentUrl()));

        String[] resourcesOptions = {"Resident Experience 101",
                "Reducing Fraud & Late Payments",
                "Making The Switch to Centralized Leasing",
                "Choosing the Right Property Management Software",
                "What's Next in Multifamily Marketing?",
                "Managing Student Housing",
                "Engage and Convert Multifamily Leads",
                "Everything to Know About Renters Insurance",
                "Centralizing Multifamily Operations"};

        synchronized (driver) {
            driver.wait(3000);
        }

        for (int i=1; i<10; i++) {
            WebElement resources = driver.findElement(By.xpath("(//div[@class='resources-grid-headline'])[" + i + "]"));
            Assert.assertTrue(resourcesOptions[i-1].equals(resources.getText()));
            WebElement readMoreButton = driver.findElement(By.xpath("(//a[@title='Read More'])["+i+"]"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.elementToBeClickable(readMoreButton));

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", readMoreButton);

            synchronized (driver) {
                driver.wait(3000);
            }

            //Verify the expected header text with actual header text of individual resource guide
                WebElement headerText = driver.findElement(By.xpath("//h2[normalize-space()=\"" + resourcesOptions[i - 1] + "\"]"));
                String header = headerText.getText();
                Assert.assertTrue(header.equals(resourcesOptions[i - 1]));
                driver.navigate().back();
        }
        driver.quit();
    }
}

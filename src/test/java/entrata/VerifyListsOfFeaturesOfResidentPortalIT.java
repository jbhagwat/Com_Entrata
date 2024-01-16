package entrata;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyListsOfFeaturesOfResidentPortalIT {

    /**
     *  This test will verify the redirecting from 'entrata.com' to 'residentportal.com'
     *  Also will verify the 'Features' section along with list of features
     */

    @Test
    public void verifyFeaturesListOfResidentPortal() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.entrata.com/");

        WebElement signInButton = driver.findElement(By.xpath("//a[@class='button-default outline-dark-button']"));
        signInButton.click();

        //Used JavascriptExecutor interface to perform click operation on 'Resident Login' WebElement
        WebElement residentLoginLink = driver.findElement(By.xpath("//a[contains(@class,'dark-cta-link banner-link')]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", residentLoginLink);

        //This will verify the expected resident portal url
        String expectedResidentPortalUrl = "https://www.residentportal.com/";
        String actualResidentPortalUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualResidentPortalUrl, expectedResidentPortalUrl);

        WebElement viewTheWebsiteButton = driver.findElement(By.xpath("//div[@class='start-button website-button']"));
        viewTheWebsiteButton.click();

        //This will verify the expected resident portal page title and heading text
        String expectedResidentPortalPageTitle = "Welcome to the Resident Portal App";
        String expectedResidentPortalHeadingText = "Welcome to\n" +"ResidentPortal";
        String actualResidentPortalPageTitle = driver.getTitle();
        String actualResidentPortalHeadingText = driver.findElement(By.xpath("//div[@class='two-third']")).getText();
        Assert.assertEquals(actualResidentPortalPageTitle, expectedResidentPortalPageTitle);
        Assert.assertEquals(actualResidentPortalHeadingText, expectedResidentPortalHeadingText);

        WebElement featuresSection = driver.findElement(By.xpath("//div[@class='landing-nav four-content']//a[contains(text(),'Features')]"));
        featuresSection.click();

        List<WebElement> featuresList = driver.findElements(By.xpath("//div[@class='feature4-list four-content']"));

        String featuresArrayList ="Amenities\n" +
                "Classifieds\n" +
                "Community Feed\n" +
                "Events\n" +
                "Messages\n" +
                "Mobile Friendly/Responsive Templates\n" +
                "Property Services\n" +
                "Recurring Payments\n" +
                "Referrals\n" +
                "Rentable Items\n" +
                "Resident Alerts\n" +
                "Reviews\n" +
                "And much more!";

        for (WebElement feature : featuresList) {

            String featureName = feature.getText();
            Assert.assertEquals(featureName, featuresArrayList);
        }
        driver.quit();
    }
}

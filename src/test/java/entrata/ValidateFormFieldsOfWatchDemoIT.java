package entrata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateFormFieldsOfWatchDemoIT {

    @Test
    public void validateAllTheFieldsOfWatchDemoSection() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.entrata.com/");

        WebElement watchDemoButton = driver.findElement(By.linkText("Watch Demo"));
        watchDemoButton.click();

        WebElement firstNameTextField = driver.findElement(By.id("FirstName"));
        WebElement lastNameTextField = driver.findElement(By.id("LastName"));
        WebElement emailTextField = driver.findElement(By.id("Email"));
        WebElement companyTextField = driver.findElement(By.id("Company"));
        WebElement phoneNumberTextField = driver.findElement(By.id("Phone"));
        WebElement unitCountDropdown = driver.findElement(By.id("Unit_Count__c"));
        WebElement jobTitleTextField = driver.findElement(By.id("Title"));
        WebElement watchDemoButtonOfForm = driver.findElement(By.xpath("//button[contains(text(),'Watch Demo')] "));

        Assert.assertTrue(firstNameTextField.isDisplayed());
        Assert.assertTrue(lastNameTextField.isDisplayed());
        Assert.assertTrue(emailTextField.isDisplayed());
        Assert.assertTrue(companyTextField.isDisplayed());
        Assert.assertTrue(phoneNumberTextField.isDisplayed());
        Assert.assertTrue(unitCountDropdown.isDisplayed());
        Assert.assertTrue(jobTitleTextField.isDisplayed());
        Assert.assertTrue(watchDemoButtonOfForm.isDisplayed());

        driver.quit();
    }
}

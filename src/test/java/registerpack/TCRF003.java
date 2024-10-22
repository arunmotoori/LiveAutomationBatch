package registerpack;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCRF003 {

	@Test
	public void verifyRegisteringAccountWithAllFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountDropMenu.click();
		
		WebElement registerOption = driver.findElement(By.linkText("Register"));
		registerOption.click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//li/a[text()='Success']")).isDisplayed());
		
		String expectedProperTextOne = "Congratulations! Your new account has been successfully created!";
		String expectedProperTextTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperTextThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperTextFour = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperTextFive = "contact us";
		
		String actualText = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(actualText.contains(expectedProperTextOne));
		Assert.assertTrue(actualText.contains(expectedProperTextTwo));
		Assert.assertTrue(actualText.contains(expectedProperTextThree));
		Assert.assertTrue(actualText.contains(expectedProperTextFour));
		Assert.assertTrue(actualText.contains(expectedProperTextFive));
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		
	}
	
    public static String generateNewEmail() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	}

}

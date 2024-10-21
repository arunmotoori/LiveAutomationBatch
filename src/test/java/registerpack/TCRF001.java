package registerpack;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCRF001 {

	@Test
	public void registerWithMandatoryFields() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedHeading = "Your Account Has Been Created!";
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(),expectedHeading);
		
		String expectedTextOne = "Congratulations! Your new account has been successfully created!";
		String expectedTextTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedTextThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedTextFour = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String expectedTextFive = "contact us";
		
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(expectedTextOne));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(expectedTextTwo));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(expectedTextThree));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(expectedTextFour));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(expectedTextFive));
		
		driver.findElement(By.xpath("//div[@id='content']//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		
	}
	
	public String generateEmail() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	}

}

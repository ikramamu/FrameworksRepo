package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class charterMethods extends baseClass {
	
	@SuppressWarnings("deprecation")
	@Test
	public void LaunchPage() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spectrum.com/address/localization");
		driver.manage().window().maximize();
		// Implicit wait that has been deprected in current version.
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address-line1--data']")));
		addressField.sendKeys("345 park ave");
		driver.findElement(By.xpath("//input[@id='address-line2--data']")).sendKeys("apt 202");
		driver.findElement(By.xpath("//input[@id='zipcode--data']")).sendKeys("14830");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// MOuse hover using actions class
		//Actions action = new Actions(driver);
		WebElement IamNewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/buy/featured']")));
		//action.moveToElement(IamNewButton).click().perform();
		IamNewButton.click();
		
		//ScreenShot
		baseClass.takeScreenShots(driver);
		
		
		
	}
	
	

}

package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class baseClass {
	
	//WebDriver driver;
	
	public static void takeScreenShots(WebDriver driver) throws IOException {
		// ScreenSHots
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File destination  = new File(".//screens//screen1.png");
				Files.copy(srcFile, destination);
	}

}

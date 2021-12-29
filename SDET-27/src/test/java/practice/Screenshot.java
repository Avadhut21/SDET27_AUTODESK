package practice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	@Test
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/ss.png");

		driver.close();
	}
}




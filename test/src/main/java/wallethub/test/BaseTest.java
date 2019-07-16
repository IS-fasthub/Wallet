package wallethub.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	public static WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
}

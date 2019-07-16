package wallethub.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookSignInPage extends BasePage {

	public WebElement getLoginEmailField() {
		
		return driver.findElement(By.xpath("//input[@id='email']"));
	}
	
	public WebElement getLoginPasswordField() {
		
		return driver.findElement(By.xpath("//input[@id='pass']"));
	}
	
	public WebElement getSubmitButton() {
		
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	
}

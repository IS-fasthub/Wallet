package wallethub.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WalletHubLoginPage extends BasePage {

	public WebElement getLogInForm() {

		return driver.findElement(
				By.xpath("//form[@name]"));
	}
	
	public WebElement getEmailField() {

		return driver.findElement(
				By.xpath("//input[@name='em']"));
	}
	
	public WebElement getPasswordField() {

		return driver.findElement(
				By.xpath("//input[@name='pw']"));
	}
	
	public WebElement getButtonLogin() {

		return driver.findElement(
				By.xpath("//span[text()='Login']/parent::button"));
	}
	
	public ExpectedCondition<Boolean> logInFormToAppear = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@name='em']")).isDisplayed();
		}
	};
}
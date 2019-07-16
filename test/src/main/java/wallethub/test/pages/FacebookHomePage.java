package wallethub.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class FacebookHomePage  extends BasePage {

	public WebElement getLabelLoggedInUsername() {

		return driver.findElement(
				By.xpath("//div[@aria-label='Facebook' and @role='navigation']//img/following-sibling::span"));
	}

	public WebElement getButtonHome() {

		return driver.findElement(By.xpath("//div[@aria-label='Facebook' and @role='navigation']//a[text()='Home']"));
	}

	public WebElement getLinkCreatePost() {

		return driver.findElement(By.xpath("//a[@data-attachment-type='STATUS']"));
	}
	
	public WebElement getTextAreaWall() {

		return driver.findElement(By.xpath("//div[@aria-autocomplete='list']"));
	}

	public WebElement getButtonShare() {

		return driver.findElement(By.xpath("//span[text()='Share']/parent::button"));
	}

	public WebElement getButtonSettings() {

		return driver.findElement(By.xpath("//div[@id='userNavigationLabel']"));
	}
	
	public WebElement getLinkLogOut() {

		return driver.findElement(By.xpath("//span[text()='Log Out']"));
	}
	
	public ExpectedCondition<Boolean> wallToAppear = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return getTextAreaWall().isDisplayed();
		}
	};
	
	public ExpectedCondition<Boolean> settingMenuListToAppear = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return driver.findElement(By.xpath("//ul[@role='menu']")).isDisplayed();
		}
	};

}

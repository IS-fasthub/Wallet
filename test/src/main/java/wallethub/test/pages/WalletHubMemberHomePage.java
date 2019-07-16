package wallethub.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WalletHubMemberHomePage extends BasePage {

	public WebElement getPageHeader() {

		return driver.findElement(By.xpath("//h1"));
	}

	public WebElement getLoggedInUser() {

		return driver.findElement(By.xpath("//div[contains(@class, 'brgm-user')]//span[@class='brgm-list-title']"));
	}

	public List<WebElement> getListOfStars() {

		return driver.findElements(By
				.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg']"));
	}

	public boolean verifyStarsHighlighted(int starsSelected) {

		List<WebElement> listOfSelectedStars = driver.findElements(By.xpath(
				"//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg']//*[@fill='none']"));

		boolean selected = true;

		if (listOfSelectedStars.size() != starsSelected)
			return false;

		for (WebElement we : getListOfStars()) {

			if (!we.findElement(By.xpath(
					"//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg']//*[@fill='none']"))
					.isDisplayed())
				selected = false;
		}

		return selected;

	}

	public WebElement getDropdownPolicy() {

		return driver.findElement(By.xpath("//div[@class='dropdown second']//span[@class='dropdown-placeholder']"));
	}

	public WebElement getPolicyList() {

		return getDropdownPolicy()
				.findElement(By.xpath("//following-sibling::ul[@class='dropdown-list ng-enter-element']"));
	}

	public WebElement getPolicyOption(String option) {

		WebElement policyOption = getDropdownPolicy().findElement(By
				.xpath("//following-sibling::ul[@class='dropdown-list ng-enter-element']/li[text()='" + option + "']"));
		return policyOption;
	}

	public WebElement getTextareaReview() {

		return driver.findElement(By.xpath("//div[@class='android']//textarea"));
	}

	public WebElement getLinkSubmitReview() {

		return driver.findElement(By.xpath("//div[text()='Submit']"));
	}
	
	public ExpectedCondition<Boolean> loggedInUsernameToAppear = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return driver.findElement(By.xpath("//div[contains(@class, 'brgm-user')]//span[@class='brgm-list-title']")).isDisplayed();
		}
	};

}

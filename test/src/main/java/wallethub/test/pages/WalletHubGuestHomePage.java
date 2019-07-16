package wallethub.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WalletHubGuestHomePage extends BasePage{

	public WebElement getLinkLogIn() {

		return driver.findElement(
				By.xpath("//span[text()='Login']"));
	}
}

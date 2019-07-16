package wallethub.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wallethub.test.pages.FacebookHomePage;
import wallethub.test.pages.FacebookSignInPage;
import wallethub.test.pages.WalletHubGuestHomePage;
import wallethub.test.pages.WalletHubLoginPage;
import wallethub.test.pages.WalletHubMemberHomePage;
import wallethub.test.utils.Utilities;

/**
 * Hello world!
 *
 */
public class App extends BaseTest
{
	@BeforeMethod
	public void preRequisites() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	
	@AfterMethod
	public void postRequisites() {
		driver.quit();
	}
	
	@Test
    public void assignmentOne() {
    	
    	String url = Utilities.getPropertyValue("assignment1.url");
    	//username from test.properties file
    	String username = Utilities.getPropertyValue("assignment1.username");
    	//password from test.properties file
    	String password = Utilities.getPropertyValue("assignment1.password");
    	//loggedInUser from test.properties file
    	String loggedInUser = Utilities.getPropertyValue("assignment1.loggedInUser");
    	
    	driver.get(url);
    	driver.manage().window().maximize();
    	
    	FacebookSignInPage fbSignInPage1 = new FacebookSignInPage();
    	fbSignInPage1.waitForPageToLoad();
    	    	
    	fbSignInPage1.getLoginEmailField().sendKeys(username);
    	fbSignInPage1.getLoginPasswordField().sendKeys(password);
    	fbSignInPage1.getSubmitButton().click();
    	
    	FacebookHomePage homePage = new FacebookHomePage();
    	homePage.waitForPageToLoad();
    	
    	Assert.assertEquals(homePage.getLabelLoggedInUsername().getText(), loggedInUser);
    	
    	homePage.getLinkCreatePost().click();
    	
    	wait.until(homePage.wallToAppear);
    	homePage.getTextAreaWall().click();
    	homePage.getTextAreaWall().sendKeys("Hello World");
    	homePage.getButtonShare().click();
    	
    	homePage.getButtonSettings().click();
    	wait.until(homePage.settingMenuListToAppear);
    	homePage.getLinkLogOut().click();
    	
    	FacebookSignInPage fbSignInPage2 = new FacebookSignInPage();
    	
    	Assert.assertTrue(fbSignInPage2.getLoginEmailField().isDisplayed());
    	
    }
    
    @Test
    public void assignmentTwo() {
    	
    	String url1 = Utilities.getPropertyValue("assignment2.testCompanyUrl");
    	//email from test.properties file
    	String email = Utilities.getPropertyValue("assignment2.email");
    	//password from test.properties file
    	String password = Utilities.getPropertyValue("assignment2.password");
    	//username from test.properties file
    	String username = Utilities.getPropertyValue("assignment2.username");
    	
    	driver.get(url1);
    	driver.manage().window().maximize();
    	
    	WalletHubGuestHomePage guestPage = new WalletHubGuestHomePage();
    	guestPage.waitForPageToLoad();
    	guestPage.getLinkLogIn().click();
    	
    	WalletHubLoginPage loginPage = new WalletHubLoginPage();
    	wait.until(loginPage.logInFormToAppear);
    	
    	loginPage.getEmailField().sendKeys(email);
    	loginPage.getPasswordField().sendKeys(password);
    	loginPage.getButtonLogin().click();
    	
    	WalletHubMemberHomePage memberHomePage1 = new WalletHubMemberHomePage();
    	wait.until(memberHomePage1.loggedInUsernameToAppear);
    	Assert.assertTrue(memberHomePage1.getLoggedInUser().getText().equalsIgnoreCase(username), "Logged in user is correctly displayed as "+username);
    	
    	WebElement fourthStar = memberHomePage1.getListOfStars().get(3);
    	WalletHubMemberHomePage.scrollIntoView(fourthStar);
    	Actions action = new Actions(driver);
    	action.moveToElement(fourthStar).build().perform();
    	
    	WalletHubMemberHomePage memberHomePage2 = new WalletHubMemberHomePage();
    	Assert.assertTrue(memberHomePage2.verifyStarsHighlighted(4), "All 4 stars should be highlighted");
    	
    	memberHomePage2.getListOfStars().get(4).click();
    	wait.until(ExpectedConditions.visibilityOf(memberHomePage2.getDropdownPolicy()));
    	
    	memberHomePage2.getDropdownPolicy().click();
    	memberHomePage2.getPolicyOption("Health Insurance").click();
    	memberHomePage2.getTextareaReview().sendKeys(Utilities.getPropertyValue("assignment2.reviewText"));
    	memberHomePage2.getLinkSubmitReview().click();
    	
    	//After this step I am getting "WE ENCONTERED AN ERROR. PLEASE RETRY" message
    	//Hence couldn't proceed
    }
	
}

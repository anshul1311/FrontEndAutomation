package pom;

import object.repo.ThankYouPageRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;
import org.testng.*;

import java.io.IOException;


public class ThankYouPage extends BrowserUtils {
	WebDriver driver;
	private Driver wrapperWebDriver=new Driver();
	private ThankYouPageRepo confirmRepo;

	
	public ThankYouPage() throws IOException {
		super();
		confirmRepo=PageFactory.initElements(getDriver(), ThankYouPageRepo.class);
		wrapperWebDriver.setDriver(getDriver());
		}
	//this method will verify the details on ThankYou Page
	public void verifyDetails() {
		for (int i = 0; i < confirmRepo.tblThankYou.size(); i++) {
			//wrapperWebDriver.waitForElementToBeClickable(confirmRepo.tblThankYou.get(i));

			WebElement ele = confirmRepo.tblThankYou.get(i).findElement(By.xpath("./td/following-sibling::td"));
			System.out.println(ele.getText());
			Assert.assertEquals(ele.getText().isEmpty(),false);
		}
	}
	//will verify the title
	public void verifyPageTitle(){
		wrapperWebDriver.waitForPageLoad();
		Assert.assertEquals(wrapperWebDriver.getTitle(),"BlazeDemo Confirmation");
	}
	
}

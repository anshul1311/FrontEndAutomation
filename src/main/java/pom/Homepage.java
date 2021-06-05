package pom;

import object.repo.HomepageRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;
import utils.ReadConfig;

import java.io.IOException;

public class Homepage extends BrowserUtils {
	private Driver wrapperWebDriver=new Driver();
	private HomepageRepo homePageRepo;
	public ReadConfig readConfig=ReadConfig.getInstance("Data.properties");


	public Homepage() throws IOException {

		
		homePageRepo=PageFactory.initElements(getDriver(), HomepageRepo.class);
		wrapperWebDriver.setDriver(getDriver());
		
}

	//This will select the source Location
	public Boolean setSourceLocation() throws InterruptedException{
		Thread.sleep(3000);
		wrapperWebDriver.waitForElementToBeClickable(homePageRepo.drpDownFrom);
		wrapperWebDriver.selectByName(homePageRepo.drpDownFrom,readConfig.getTo());

		return true;
		
	}
	//This will select the Destination Location
	public void setDestinationLocation(){
		wrapperWebDriver.waitForElementToBeClickable(homePageRepo.drpDownTo);

		wrapperWebDriver.selectByName(homePageRepo.drpDownTo,readConfig.getFrom());
	}
	//This will search for the flights
	public void clickSearchButton(){
		
		wrapperWebDriver.click(homePageRepo.btnSubmit);
		//return resultsPage;
	}
}

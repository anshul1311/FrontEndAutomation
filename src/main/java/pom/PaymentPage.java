package pom;

import object.repo.PaymentPageRepo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.Driver;
import utils.ReadConfig;

import java.io.IOException;

public class PaymentPage extends BrowserUtils {
	WebDriver driver;
	private Driver wrapperWebDriver=new Driver();
	private PaymentPageRepo paymentRepo;
	public ReadConfig readConfig=ReadConfig.getInstance("Data.properties");



	public PaymentPage() throws IOException {
		// TODO Auto-generated constructor stub

		paymentRepo=PageFactory.initElements(getDriver(), PaymentPageRepo.class);
		wrapperWebDriver.setDriver(getDriver());
	}
	//This will enter Email
	public void enterName(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtName);
		wrapperWebDriver.sendKeys(paymentRepo.txtName, readConfig.getName());
	}
	//This will enter the Continue button for Login
	public void enterAddress(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtAddress);
		wrapperWebDriver.sendKeys(paymentRepo.txtAddress,readConfig.getAddress());
	}
	//This method selects the title value
	public void enterCity(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtCity);
		wrapperWebDriver.sendKeys(paymentRepo.txtCity,readConfig.getCity());
	}
	//This will enter the first name
	public void enterState(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtState);
		wrapperWebDriver.sendKeys(paymentRepo.txtState, readConfig.getCity());
		
	}
	//This will enter the Last Name
	public void enterZipCode(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtZipCode);
		wrapperWebDriver.sendKeys(paymentRepo.txtZipCode, readConfig.getPinCode());
		
	}
	//This will enter the Mobile Number
	public void enterCardType(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.drpDownCardType);
		wrapperWebDriver.selectByName(paymentRepo.drpDownCardType, readConfig.getCardType());
		
	}
	
	public void enterCreditCardNumber(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtCardNumber);
		wrapperWebDriver.sendKeys(paymentRepo.txtCardNumber,readConfig.getCardNumber());
	}


	public void enterCreditCardMonth(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtCreditCardMonth);
		wrapperWebDriver.sendKeys(paymentRepo.txtCreditCardMonth,readConfig.getCardMonth());
	}


	public void enterCreditCardYear(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtCreditCardYear);
		wrapperWebDriver.sendKeys(paymentRepo.txtCreditCardYear,readConfig.getCardYear());
	}


	public void enterNameOnCard(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.txtNameOnCard);
		wrapperWebDriver.sendKeys(paymentRepo.txtNameOnCard,readConfig.getName());
	}

	public void selectRememberMe(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.chkBoxRememberMe);
		wrapperWebDriver.click(paymentRepo.chkBoxRememberMe);
	}

	public void clickBook(){
		wrapperWebDriver.waitForElementToBeClickable(paymentRepo.btnBook);
		wrapperWebDriver.click(paymentRepo.btnBook);
	}

public void enterPaymentDetails(){
	enterName();
	enterAddress();
	enterCardType();
	enterCity();
	enterCreditCardNumber();
	enterCreditCardMonth();
	enterCreditCardYear();
	enterNameOnCard();
	enterState();
	enterZipCode();
	clickBook();

}

	public void verifyPageTitle(){
		Assert.assertEquals(wrapperWebDriver.getTitle(),"BlazeDemo Purchase");
	}
}

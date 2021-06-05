package object.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPageRepo {

	
	@FindBy(id="inputName")
	public WebElement txtName;
	
	@FindBy(id="address")
	public WebElement txtAddress;

	@FindBy(id="city")
	public WebElement txtCity;

	@FindBy(id="state")
	public WebElement txtState;

	@FindBy(id="zipCode")
	public WebElement txtZipCode;

	@FindBy(id="cardType")
	public WebElement drpDownCardType;

	@FindBy(id="creditCardNumber")
	public WebElement txtCardNumber;
	
	@FindBy(id="creditCardMonth")
	public WebElement txtCreditCardMonth;
	
	@FindBy(id="creditCardYear")
	public WebElement txtCreditCardYear;
	
	@FindBy(id="nameOnCard")
	public WebElement txtNameOnCard;

	@FindBy(id="rememberMe")
	public WebElement chkBoxRememberMe;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement btnBook;
}

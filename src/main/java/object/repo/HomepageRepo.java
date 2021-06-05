package object.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomepageRepo {
	
	@FindBy(name="fromPort")
	public WebElement drpDownFrom;
	
	@FindBy(name="toPort")
	public WebElement drpDownTo;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement btnSubmit;

}

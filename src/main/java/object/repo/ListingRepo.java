package object.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListingRepo {

	@FindBy(xpath="//table/tbody/tr")
	public List<WebElement> tblListing;

}

package pom;

import object.repo.ListingRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.Driver;
import utils.ReadConfig;

import java.io.IOException;

public class ListingPage extends BrowserUtils {
    private Driver wrapperWebDriver = new Driver();
    private ListingRepo listingRepo;
    public ReadConfig readConfig=ReadConfig.getInstance("Data.properties");



    public ListingPage() throws IOException {
        listingRepo = PageFactory.initElements(getDriver(), ListingRepo.class);
        wrapperWebDriver.setDriver(getDriver());
    }

    public void selectFlightAndProceed(int index) throws InterruptedException {
		wrapperWebDriver.waitForPageLoad();
		listingRepo.tblListing.get(index).findElement(By.xpath("./td[1]")).click();

    }

    public void verifyPageTitle(){
        Assert.assertEquals(wrapperWebDriver.getTitle(),"BlazeDemo - reserve");
    }
}

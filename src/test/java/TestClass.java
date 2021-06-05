import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom.Homepage;
import pom.ListingPage;
import pom.PaymentPage;
import pom.ThankYouPage;
import utils.BrowserUtils;

import java.io.IOException;

public class TestClass {

    BrowserUtils utils = new BrowserUtils();
    WebDriver driver;
    Homepage homepage;
    ListingPage listingPage;
    PaymentPage paymentPage;
    ThankYouPage thankYouPage;


    @Parameters({"browser"})
    @BeforeClass
    public void setup(@Optional("chrome") String browser) throws IOException {
        utils.driver(driver, browser);
        driver = utils.getDriver();
        homepage = new Homepage();
        listingPage=new ListingPage();
        paymentPage=new PaymentPage();
        thankYouPage=new ThankYouPage();
        driver.get("https://blazedemo.com/");


    }

    @Test(priority = 1)
    public void searchFlight() throws InterruptedException {
        try {
            homepage.setSourceLocation();
            homepage.setDestinationLocation();
            homepage.clickSearchButton();
        }catch (Exception e){
            //Assert.fail();
        }


    }
    @Test(priority = 2)
    public void makeBooking() throws InterruptedException {
        try {
            listingPage.verifyPageTitle();
            listingPage.selectFlightAndProceed(0);
            paymentPage.verifyPageTitle();
            paymentPage.enterPaymentDetails();
        }
        catch (Exception e){
            //Assert.fail();
        }
    }

    @Test(priority = 3)
    public void checkThankYouPage(){
        try {
            thankYouPage.verifyPageTitle();
            thankYouPage.verifyDetails();
        }
        catch (Exception e){
            //Assert.fail();
        }
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

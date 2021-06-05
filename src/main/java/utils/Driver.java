package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver implements WebDriver {
	private  WebDriver driver;

	public  void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	//private Logger logger=Logger.getLogger(utils.Driver.class);

	
	
	public WebDriver getDriver(){
		return driver;
		}
	
	public void windowMaximize(){
		driver.manage().window().maximize();
	}
	
	public void chooseFromDropDownBasedOnValue(WebElement e,String value){
		new Select(e).selectByValue(value);
	}
	
	public void click(WebElement e){
		//logger.info("Clicking on element:"+e);
		e.click();
	}
	public void sendKeys(WebElement e,String str){
		e.sendKeys(str);
	}
	
	public void waitForElementToBeClickable(WebElement e){
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void close() {
		driver.close();		
	}

	public WebElement findElement(By arg0) {
		return driver.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {

		return null;
	}

	public void get(String arg0) {
		//logger.info("Navigating to Url"+arg0);
		driver.get(arg0);
	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectByIndex(WebElement ele,int index){
		Select select=new Select(ele);
		select.selectByIndex(index);
	}

	public void selectByName(WebElement ele,String name){
		Select select=new Select(ele);
		select.selectByVisibleText(name);
	}

	public void waitForPageLoad() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String
						.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

}

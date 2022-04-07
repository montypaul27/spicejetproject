package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityclasses.DivCalendarUtility;

public class Loginpage
{
	//define element locators
	@FindBy(xpath="//div[@data-testid='round-trip-radio-button']") public WebElement roundtrip;
	@FindBy(xpath="//div[text()='From']/following::input[1]") public WebElement clearfrom;
	@FindBy(xpath="//div[text()='From']/following::input[1]") public WebElement departure ;
@FindBy(xpath="//div[text()='To']/following::input[1]") public WebElement cleardest;
@FindBy(xpath="//div[text()='To']/following::input[1]") public WebElement destination;
//@FindBy(xpath="//div[@data-focusable='true'])[16]") public WebElement scroll;

@FindBy(xpath="(//*[name()='svg'])[12]") public WebElement deptcalendar;
@FindBy(xpath="(//div[contains(@data-testid,'undefined-month')])[1]/ancestor::div[2]") public WebElement calendar;
@FindBy(xpath="(//*[name()='svg'])[13]") public WebElement returncalendar;
@FindBy(xpath="//div[text()='1 Adult']") public WebElement passengers;
@FindBy(xpath="//div[text()='Students']") public WebElement studentbutton;
@FindBy(xpath="(//*[name()='rect'])[2]") public WebElement checkbox;
@FindBy(xpath="(//div[text()='Continue'])[2]") public WebElement Continue;
@FindBy(xpath="//div[@data-testid='home-page-flight-cta']") public WebElement searchflight;

	//Constructor method
	public Loginpage(RemoteWebDriver driver)
	{
		//connect "driver" object to above defined locators
		PageFactory.initElements(driver, this);
	}
	//operational and observation methods
	public void clickroundtrip() throws Exception
	{
		roundtrip.click();
		Thread.sleep(5000);
	}
	public void clearDep() throws Exception
	{
		departure.clear();
		Thread.sleep(5000);
	}
	public void fillDeparture(String x) throws Exception
	{
		departure.sendKeys(x);
		Thread.sleep(5000);
	}
	public void clearto() throws Exception
	{
		cleardest.clear();
		Thread.sleep(5000);
	}
	public void fillDestination(String y) throws Exception
	{
		destination.sendKeys(y);
		Thread.sleep(5000);
	}
	public void departdate(RemoteWebDriver driver,int z,String y, int x) throws Exception
	{
		//driver.executeScript("(arguments[0].scrollIntoview());",scroll);
		DivCalendarUtility obj=new DivCalendarUtility();
		//calendar.click();
		obj.selectDate(driver,calendar,z, y, x);	
		Thread.sleep(5000);
	}
	
	public void returndate(RemoteWebDriver driver,int z, String y, int x) throws Exception
	{
		//driver.executeScript("(arguments[0].scrollIntoview());", scroll);
		DivCalendarUtility obj=new DivCalendarUtility();
		//return.click();
		obj.selectDate(driver, calendar, z, y, x);
		Thread.sleep(5000);
	}
	
	
	public void passengers()
	{
		passengers.click();
	}
	public void students() throws Exception
	{
		studentbutton.click();
		Thread.sleep(5000);
	}
	public void searchflight() throws Exception
	{
		searchflight.click();
		Thread.sleep(5000);
	}
}



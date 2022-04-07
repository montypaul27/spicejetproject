package stepdef;

import org.openqa.selenium.chrome.ChromeDriver;


import Pages.Flightpage;
import Pages.Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class spicestep
{
	public Shared sh;
	//Dependency injection via constructor
	public spicestep(Shared x)
	{
		sh=x;
	}
	
//step definition methods
@Given("open chrome browser")
public void method1()
{
	WebDriverManager.chromedriver().setup();
	sh.driver=new ChromeDriver();
	
	sh.obj1=new Loginpage(sh.driver);
	sh.obj2=new Flightpage(sh.driver);
}


@Given("launch site using {string}")
public void method2(String Url) throws Exception
{
	sh.driver.get(Url);
	Thread.sleep(5000);
}
@Then("select roundtrip")
public void method9() throws Exception
{
	sh.obj1.clickroundtrip();
}
@When("fill departure city {string}")
public void method3(String x) throws Exception
{
	sh.obj1.fillDeparture(x);
}
@Then("clear destination")
public void method10() throws Exception
{
	sh.obj1.clearto();
}
@Then("fill destination city {string}")
public void method4(String y) throws Exception
{
	sh.obj1.fillDestination(y);
	Thread.sleep(5000);
}
@When("select a departure year {int} departure month {string} and departure day {int}")
public void method5(Integer dy,String dm,Integer dd) throws Exception
{
	sh.obj1.departdate(sh.driver, dy, dm, dd);
	}

@And("click on arrival year {int} arrival month {string} and arrival day {int}")
public void method6(Integer ay,String am,Integer ad)  throws Exception
{
	sh.obj1.returndate(sh.driver, ay, am, ad);
}
@Then("click on Search Flight button")
public void method7() throws Exception
{
	sh.obj1.searchflight();
}
@And("select lowest fare flight for departure")
	public void method8()
	{
	sh.obj2.selectLowestFareD(sh.driver);
	}

@And("select lowest fare flight for return")
public void method12()
{
	sh.obj2.selectLowestFareR(sh.driver);
}

@Then("click continu")
public void method13() throws Exception
{
	sh.obj2.clickContinue();
}
@And("select highest fare flight for departure")
public void method14() throws Exception
{
	sh.obj2.selectHighestFareD(sh.driver);
	 
}
@And("select highest fare flight for return")
public void method15()
{
	 sh.obj2.selectHighestFareR(sh.driver);
}

}

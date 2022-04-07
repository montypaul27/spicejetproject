package stepdef;


import org.openqa.selenium.remote.RemoteWebDriver;

import Pages.Flightpage;
import Pages.Loginpage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Shared 
{
	//declare common objects
	public RemoteWebDriver driver;
	public Loginpage obj1;
	public Flightpage obj2;
	public Scenario s;//to customize results file

	@Before
	public void method(Scenario x)
	{
		s=x; //define scenario object to a scenario, which is coming into execution for next
	}

}

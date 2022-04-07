package Tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Spicejet/spicejetlowest.feature",
glue="stepdef",
plugin= {"pretty","html:target/my results"},
monochrome=true)

		
public class MyRunner
{
	

}

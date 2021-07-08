package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features\\cadastro.feature",
		glue     = "steps",
		tags     = "@login",
		plugin   = {"pretty", "html:target/cucumber.html"}
		)
public class Runner {

}

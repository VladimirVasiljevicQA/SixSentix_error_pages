package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"html:target/cucmber_html_report.html","pretty"},
features="src/test/java/Features",
glue={"StepDefinitions"},
tags="@all"
		
)
public class runEnDe extends AbstractTestNGCucumberTests{

}

package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"pretty","html:target/html/automation","json:target/cucumber.json"},
                features = {"."},
                glue={"com.automation.steps"},
                tags={"@apiScenario,@uiScenario"}
        )
public class AutomationTestRunner {
	

}

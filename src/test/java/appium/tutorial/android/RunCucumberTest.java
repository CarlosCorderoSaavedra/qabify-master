package appium.tutorial.android;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,  features = {
        "src/test/resources/features/",
    },monochrome=true)
public class RunCucumberTest {
}
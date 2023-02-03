package StepDefinetion;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",glue={"StepDefinetion"},monochrome=true,plugin = {"json:target/reports.json"},tags="@sanity")

public class TestRunner {

}

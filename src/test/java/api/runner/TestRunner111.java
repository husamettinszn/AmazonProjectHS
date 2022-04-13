package api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\default-cucumber_reports.html",
                "json:target\\json-reports/cucumber.json",
                "junit:target\\xml-report/cucumber.xml" },
        features = "src/test/resources/uiFeature",
        glue = "ui/stepdefinitions",
        dryRun = false,
        tags = "@wip"
)
public class TestRunner111 {
}

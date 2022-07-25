package com.online_calculatort.Seleniumautomation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/java/com/online_calculatort/Seleniumautomation/feature"
        , glue = {"com.online_calculatort.Seleniumautomation.definition", "com.online_calculatort.Seleniumautomation.config"},
        monochrome = true,
        plugin = {"pretty",
                "json:target/output/HtmlReports.json", "html:target/output/HtmlReports.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

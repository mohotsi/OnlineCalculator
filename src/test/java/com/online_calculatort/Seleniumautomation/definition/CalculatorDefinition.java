package com.online_calculatort.Seleniumautomation.definition;

import com.online_calculatort.Seleniumautomation.Page.CalculatorPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class CalculatorDefinition {
    @Value("${application.url}")
    private String url;


    @Autowired
    @Lazy
    CalculatorPage calculatorPage;






    @Then("the screen results should display {string}")
    public void theScreenResultsShouldDisplay(String results) throws Exception {

        assertEquals("the results displayed are incorrect",Integer.valueOf(results.trim()),calculatorPage.getResults());
    }

    @Given("User enter the following keys")
    public void userEnterTheFollowingKeys(DataTable dataTable) {
        dataTable.asMaps().stream().map(operation->operation.get("key")).collect(Collectors.toList())
                .forEach(operation->calculatorPage.click(operation));
    }
}

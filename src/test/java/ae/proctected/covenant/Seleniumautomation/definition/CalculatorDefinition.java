package ae.proctected.covenant.Seleniumautomation.definition;

import ae.proctected.covenant.Seleniumautomation.Page.CalculatorPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;
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

        assertEquals("the results displayed are incorrect",(int)calculatorPage.getResults(),Integer.parseInt(results));
    }

    @Given("User enter the following keys")
    public void userEnterTheFollowingKeys(DataTable dataTable) {
        dataTable.asMaps().stream().map(operation->operation.get("key")).collect(Collectors.toList())
                .forEach(operation->calculatorPage.click(operation));
    }
}

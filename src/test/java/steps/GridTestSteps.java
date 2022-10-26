package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GridPage;

public class GridTestSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage(){
        grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue(){
        String value = grid.getValueFromGrid(2,2);

        System.out.println(value);

        Assert.assertEquals("Mayormente soleado",value);
    }

    @Then("^I can validate the table is displayed$")
    public void theTableIsThere(){
        Assert.assertTrue("Exploto todo", grid.cellStatus());
    }
}

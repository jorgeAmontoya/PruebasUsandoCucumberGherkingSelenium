package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.TestSandBox;

public class TestSandboxSteps {

    TestSandBox sandboxpage = new TestSandBox ();

    @Given("^I navigate to the sandbox page$")
    public void navigateToTheSandboxSite(){
        sandboxpage.navigateToSandbox();
    }

    @And("^select a value from the dropdown$")
    public void selectState(){
        sandboxpage.selectCategory("3");
    }
}

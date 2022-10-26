package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {

    AmazonSearchPage amazon = new AmazonSearchPage();

    @Given("^The user navigates to www.amazon.com$")
    public void navigateToAmazon(){
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria){
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("^navigates to the page number (.+)$")
    public void  navigateToSecondPage(String pageNumber){
        amazon.goToPage(pageNumber);
    }

    @And("^selects the third item$")
    public void selectsThirdItem(){

        amazon.pick3rdItem();
    }

    @Then("^the user is able to add it to the cart$")
    public void itemCanBeAddedToCart(){
        amazon.addCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }




}

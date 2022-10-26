package pages;

import org.openqa.selenium.WebDriver;

public class AmazonSearchPage extends BasePage{
    // variables
    private String searchBox = "//*[@id=\"twotabsearchtextbox\"]"; // xpath relativo @ID
    private String searchButton = "//*[@id=\"nav-search-submit-button\"]"; //xpath relativo @ID
    private String thirdResult = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[1]"; // xpath absoluto
    private String addToCartButton = "//*[@id=\"add-to-cart-button\"]"; //xpath relativo @ID
    private String addedMessageText = "//span[contains(text(),'Agregado al carrito')]"; // xpath relativo

    public AmazonSearchPage() {
        super(driver);
    }

    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com");
    }

    public void enterSearchCriteria(String criteria){
        write(searchBox, criteria);

    }

    public void clickSearch(){
        clickElement(searchButton);
    }
    public void goToPage(String pageNumber){
        goToLinkText(pageNumber);
    }

    public void pick3rdItem(){
        clickElement(thirdResult);
    }

    public void addCart(){
        clickElement(addToCartButton);
    }

    public String addedToCartMessage(){
        return textFromElement(addedMessageText);
    }

}

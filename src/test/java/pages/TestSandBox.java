package pages;
public class TestSandBox extends BasePage {

    private String categoryDropdown = "//select[@id='oldSelectMenu']";
    public TestSandBox(){
        super(driver);
    }
    public void navigateToSandbox(){
        navigateTo("https://demoqa.com/select-menu");
    }

    public void selectCategory(String category){
        selectFromDropdownByValue(categoryDropdown,category);

    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HEYLER\\Downloads\\c\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);

        wait = new WebDriverWait(driver,10);

    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
        //espera implicira, le indica a todoo el framwork que espere (esto puede poner lento la aplicacion)
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();

    }

    private WebElement Find(String locator){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByValue(valueToSelect);
        
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByIndex(valueToSelect);

    }

    public void selectFromDropdownByTest(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.deselectByVisibleText(valueToSelect);

    }


    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    //metodo para obtener el valor de una celda de una tabla
    public String getValueFromTable(String locator, int row, int column){

        //String cellINeed = locator+"//tbody/tr["+row+"]/td["+column+"]";

        String cellINeed = locator+"/tbody/tr["+row+"]/td["+column+"]";


        return Find(cellINeed).getText();
    }

    // metodo para selecionar una celda de una tabla y escribir en ella
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill =  locator+"//tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    // metodo que nos permite ir  a otro frame
    public void switchToiFrame(String iFrameID){
        driver.switchTo().frame(iFrameID);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }

    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }
    public boolean elementIsEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }


    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}

package pages;

public class GridPage extends BasePage{

   // private String cell ="//body/div[@id='document']/main[@id='content']/article[1]/section[1]/div[1]/div[1]/table[1]";
   private String cell ="//*[@id=\"header-cells\"]/div/div/table";

    private String mainTable = "//*[@id=\"concept\"]/div/div/table";
    public GridPage(){
        super(driver);
    }

    public void navigateToGrid(){
        navigateTo("https://www.htmlquick.com/es/tutorials/tables.html");
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }

    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }
}

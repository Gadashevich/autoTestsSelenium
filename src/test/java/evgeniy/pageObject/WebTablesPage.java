package evgeniy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebTablesPage extends BaseElement {
    WebDriver webDriver;
    WebDriverWait wait;

    public By getHeaderName = By.xpath("//h1[@class = 'text-center']");
    public By setAddNewRecordButton = By.xpath("//button[@id='addNewRecordButton']");
    public By setRegistrationFormFirstName = By.xpath("//input[@id='firstName']");
    public By setRegistrationFormLastName = By.xpath("//input[@id='lastName']");
    public By setRegistrationFormEmail = By.xpath("//input[@id='userEmail']");
    public By setRegistrationFormAge = By.xpath("//input[@id='age']");
    public By setRegistrationFormSalary = By.xpath("//input[@id='salary']");
    public By setRegistrationFormDepartment = By.xpath("//input[@id='department']");
    public By setRegistrationFormSubmit = By.xpath("//button[@type ='submit']");
    public By setSearch = By.xpath("//input[@id='searchBox']");


    public WebTablesPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }


    public WebTablesPage setAddButton() {
        WebElement element = webDriver.findElement(setAddNewRecordButton);
        element.click();
        return this;
    }

    public WebTablesPage setRegistrationForm(String firstName, String lastName, String mail, int age, int salary, String department) {
        WebElement elementFirstName = webDriver.findElement(setRegistrationFormFirstName);
        elementFirstName.click();
        elementFirstName.sendKeys(firstName);

        WebElement elementLastName = webDriver.findElement(setRegistrationFormLastName);
        elementLastName.click();
        elementLastName.sendKeys(lastName);

        WebElement elementEmail = webDriver.findElement(setRegistrationFormEmail);
        elementEmail.click();
        elementEmail.sendKeys(mail);

        WebElement elementAge = webDriver.findElement(setRegistrationFormAge);
        elementAge.click();
        elementAge.sendKeys(String.valueOf(age));

        WebElement elementSalary = webDriver.findElement(setRegistrationFormSalary);
        elementSalary.click();
        elementSalary.sendKeys(String.valueOf(salary));

        WebElement elementDepartment = webDriver.findElement(setRegistrationFormDepartment);
        elementDepartment.click();
        elementDepartment.sendKeys(department);

        WebElement submit = webDriver.findElement(setRegistrationFormSubmit);
        submit.click();
        return this;
    }


    public List<WebElement> getTableRows() {
        return webDriver.findElements(By.xpath(".//tr"));
    }

    public List<WebElement> getTableHeaders() {
        WebElement headingsRow = webDriver.findElement(By.xpath("//table[@class='-striped -highlight table table-striped table-bordered table-hover']/thead"));
        List<WebElement> headerColumns = headingsRow.findElements(By.xpath(".//th"));
        return headerColumns;
    }

    public List<List<WebElement>> getTableRowsWithColumns() {
        List<WebElement> rows = getTableRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public List<Map<String,WebElement>> getRowsWithColumnsByHeaders(){
        List<List<WebElement>> rowsWithColumns= getTableRowsWithColumns();
        List<Map<String,WebElement>> rowsWithColumnsByHeaders = new ArrayList<>();
        Map<String, WebElement> rowByHeaders;
        List<WebElement> tableHeaders = getTableHeaders();

        for (List<WebElement> row : rowsWithColumns) {
          rowByHeaders = new HashMap<>();
            for (int i = 0; i <tableHeaders.size() ; i++) {
                String headers = tableHeaders.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeaders.put(headers,cell);
            }
            rowsWithColumnsByHeaders.add(rowByHeaders);
        }
        return  rowsWithColumnsByHeaders;
    }

    public String getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getTableRowsWithColumns();
        WebElement element = rowsWithColumns.get(rowNumber  ).get(columnNumber -1);
        return element.getText();

    }

    public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsByHeaders = getRowsWithColumnsByHeaders();
        String text = rowsWithColumnsByHeaders.get(rowNumber - 1).get(columnName).getText();
        return text;
    }
}

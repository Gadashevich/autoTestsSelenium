package evgeniy.pageTest;

import evgeniy.pageObject.BaseElement;
import evgeniy.pageObject.WebTablesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTablesTest extends BaseElement {
    WebTablesPage webTablesPage;

    @BeforeEach
    @Override
    public void setup() {
        super.setup();
        webTablesPage = new WebTablesPage(webDriver, new WebDriverWait(webDriver, Duration.ofSeconds(5)));
        webDriver.get("https://demoqa.com/webtables");
    }

    @AfterEach
    public void end() {
        webDriver.close();
    }


    @Test
    public void checkHeaderPageName() {
        String headerName = webDriver.findElement(webTablesPage.getHeaderName).getText();
        Assertions.assertEquals(headerName, "Web Tables");
    }

    @Test
    public void checkTableHeaders() {
        List<WebElement> tableHeaders = webTablesPage.getTableHeaders();
        Assertions.assertEquals("First Name", tableHeaders.get(0).getText());
        Assertions.assertEquals("Last Name", tableHeaders.get(1).getText());
        Assertions.assertEquals("Age", tableHeaders.get(2).getText());
        Assertions.assertEquals("Email", tableHeaders.get(3).getText());
        Assertions.assertEquals("Salary", tableHeaders.get(4).getText());
        Assertions.assertEquals("Department", tableHeaders.get(5).getText());
        Assertions.assertEquals("Action", tableHeaders.get(6).getText());
    }

    @Test
    public void checkAddNewTables() {
        webTablesPage.setAddButton();

        webTablesPage.setRegistrationForm("John", "Smith", "mail@mail.ru", 20, 20000, "QA");
        webDriver.findElement(webTablesPage.setRegistrationFormSubmit).click();

        Assertions.assertEquals("John", webTablesPage.getValueFromCell(4, 1));
        Assertions.assertEquals("Smith", webTablesPage.getValueFromCell(4, 2));
        Assertions.assertEquals("20", webTablesPage.getValueFromCell(4, 3));
        Assertions.assertEquals("mail@mail.ru", webTablesPage.getValueFromCell(4, 4));
        Assertions.assertEquals("20000", webTablesPage.getValueFromCell(4, 5));
        Assertions.assertEquals("QA", webTablesPage.getValueFromCell(4, 6));
    }


    @Test
    public void check() {
        System.out.println("Rows number is: " + webTablesPage.getTableRows().size());
        System.out.println(webTablesPage.getValueFromCell(1, 1));
    }

    @Test
    public void  checkSearch(){
        WebElement fieldSearch = webDriver.findElement(webTablesPage.setSearch);
        fieldSearch.click();
        fieldSearch.sendKeys("ci");
        String valueFromCell = webTablesPage.getValueFromCell(1,1);

        Assertions.assertEquals(valueFromCell,"Cierra");
    }

}
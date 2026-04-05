package evgeniy.dataTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SimpleWebTablesTest {

    WebDriver driver = new ChromeDriver();


    By row = By.xpath("//table/tbody/child::tr");
    By column = By.xpath("//table/descendant::th");
    By getDataColumn = By.xpath("//table/tbody/child::tr[2]/td[1]");

    @BeforeEach
    public void getData() {
        driver.get("https://demoqa.com/webtables");
    }

    @AfterEach
    void close() {
        driver.close();
    }


    @Test
    public void getRows() {
        List<WebElement> elements = driver.findElements(row);
        System.out.println("Rows count: " + elements.size());

        Assertions.assertEquals(elements.size(), 3);

    }

    @Test
    public void getColumns() {
        List<WebElement> elements = driver.findElements(column);
        System.out.println("Columns count: " + elements.size());

        Assertions.assertEquals(elements.size(), 7);

    }

    @Test
    public void getDataColumn() {
        String dataColumn = driver.findElement(getDataColumn).getText();
        System.out.println("Column data: " + dataColumn);

        Assertions.assertEquals(dataColumn, "Alden");
    }

    @Test
    public void getDataTable() {
        List<WebElement> rows = driver.findElements(row);
        List<WebElement> columns = driver.findElements(column);

        for (int i = 1; i <= rows.size(); i++) {
            for (int j = 1; j <= columns.size(); j++) {
                String dataElement = driver.findElement(By.xpath("//table/tbody/child::tr[" + i + "]/td[" + j + "]")).getText();
                System.out.println(dataElement);
            }
            System.out.println("==================");
        }
    }

}

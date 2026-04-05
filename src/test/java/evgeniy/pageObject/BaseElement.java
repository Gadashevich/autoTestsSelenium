package evgeniy.pageObject;

import evgeniy.dataTest.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseElement {
  public   TestDataGenerator testDataGenerator = new TestDataGenerator();
  public   WebDriver webDriver ;


    @BeforeEach
    public void setup(){
        //   WebDriverManager.chromedriver().setup(); //в современном селениуме лишнее
        testDataGenerator.init();
        webDriver = new ChromeDriver();

    }

}



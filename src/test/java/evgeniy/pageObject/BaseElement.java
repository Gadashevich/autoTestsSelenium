package evgeniy.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseElement {
    TestDataGenerator testDataGenerator = new TestDataGenerator();
    WebDriver webDriver ;

    @BeforeEach
    public void setup(){
        //   WebDriverManager.chromedriver().setup(); //в современном селениуме лишнее, появляются ошибки в логах
        testDataGenerator.init();
        webDriver = new ChromeDriver();

    }


}



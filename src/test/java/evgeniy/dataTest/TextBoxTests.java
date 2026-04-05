package evgeniy.dataTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxTests {

    WebDriver webDriver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();

        webDriver.get("http://demoqa.com/text-box");

    }
    @AfterEach
    public void after(){
        webDriver.close();
    }


    @Test
    public void firstTest() {
        By fullNameLocator = By.xpath("//input[@id='userName']");
        WebElement userName = webDriver.findElement(fullNameLocator);
        userName.sendKeys("Петя");

        By fullUserEmail = By.xpath("//input[@id='userEmail']");
        WebElement userEmail = webDriver.findElement(fullUserEmail);
        userEmail.sendKeys("petr@mail.ru");

        By fullCurrentAddress = By.xpath("//textarea[@id='currentAddress']");
        WebElement currentAddress = webDriver.findElement(fullCurrentAddress);
        currentAddress.sendKeys("Current Address TEST");

        By fullPermanentAddress = By.xpath("//textarea[@id='permanentAddress']");
        WebElement permamentAddress = webDriver.findElement(fullPermanentAddress);
        permamentAddress.sendKeys("Permanent Address TEST2");


        By buttonSubmit = By.xpath("//button[@id='submit']");
        WebElement submit = webDriver.findElement(buttonSubmit);
        submit.click();

        By answerName = By.xpath("//p[@id ='name']");
        String elementName = webDriver.findElement(answerName).getText();
        System.out.println("TEST " + elementName);
        Assertions.assertEquals(elementName, "Name:Петя");


    }

}

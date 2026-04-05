package evgeniy.pageTest;

import evgeniy.pageObject.BaseElement;
import evgeniy.pageObject.RadioButtonPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtonTest extends BaseElement {
    RadioButtonPage radioButtonPage;

    @BeforeEach
    @Override
    public void setup() {
        super.setup();
        radioButtonPage = new RadioButtonPage(webDriver,new WebDriverWait(webDriver, Duration.ofSeconds(5)));
        webDriver.get("https://demoqa.com/radio-button");
    }

    @AfterEach
    public void end(){
        webDriver.close();
    }


    @Test
    void checkHeaderName(){
        WebElement element = webDriver.findElement(radioButtonPage.getHeaderName);
        Assertions.assertEquals(element.getText(),"Radio Button");
    }


    @Test
    void checkRadioButtonYes(){
        WebElement element = webDriver.findElement(radioButtonPage.inputRadioButtonYes);
        element.click();

        String answer = webDriver.findElement(By.xpath("//span[@class ='text-success']")).getText();
        Assertions.assertEquals(answer,"Yes");
    }

    @Test
    void checkRadioButtonImpressive(){
        WebElement element = webDriver.findElement(radioButtonPage.inputRadioButtonImpressive);
        element.click();

        String answer = webDriver.findElement(By.xpath("//span[@class ='text-success']")).getText();
        Assertions.assertEquals(answer,"Impressive");
    }

    @Test
    void checkChangeRadioButton(){
        WebElement element = webDriver.findElement(radioButtonPage.inputRadioButtonYes);
        element.click();

        WebElement element2 = webDriver.findElement(radioButtonPage.inputRadioButtonImpressive);
        element2.click();

        String answer = webDriver.findElement(By.xpath("//span[@class ='text-success']")).getText();
        Assertions.assertEquals(answer,"Impressive");
    }


}

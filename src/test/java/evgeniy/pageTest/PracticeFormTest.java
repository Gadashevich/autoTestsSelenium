package evgeniy.pageTest;

import evgeniy.pageObject.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;


public class PracticeFormTest extends PracticeFormPage {
    Actions action;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        action = new Actions(webDriver);
        webDriver.get("https://demoqa.com/automation-practice-form");
    }

    @Test

    public void checkDateOfBirth() {
        setDateOfBirth("11.10.2025");
      webDriver.findElement(inputDateOfBirthLocator).sendKeys(Keys.ENTER);
    }
}

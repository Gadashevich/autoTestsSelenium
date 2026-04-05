package evgeniy.pageTest;

import evgeniy.pageObject.ButtonsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ButtonsTest {
    ButtonsPage buttonsPage;
    WebDriver webDriver;
    Actions actions;
    WebDriverWait wait;

    @BeforeEach
    public void setup() {
        buttonsPage = new ButtonsPage();
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        actions = new Actions(webDriver);
        webDriver.get("https://demoqa.com/buttons");
    }

    @AfterEach
    public void close() {
        webDriver.close();
    }

    @Test
    public void setDoubleClick() {
        WebElement element = webDriver.findElement(buttonsPage.doubleClickButton);
        actions.moveToElement(element)
                .doubleClick(element)
                .build()
                .perform();

        String doubleClickMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id = 'doubleClickMessage']"))).getText();

        Assertions.assertEquals(doubleClickMessage, "You have done a double click");
    }

    @Test
    public void setRightClickButton() {
        WebElement element = webDriver.findElement(buttonsPage.rightClickButton);
        actions.moveToElement(element)
                .contextClick(element)
                .build()
                .perform();

        String rightClickMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id = 'rightClickMessage']"))).getText();

        Assertions.assertEquals(rightClickMessage, "You have done a right click");
    }

    @Test
    public void setClickButton() {
        webDriver.findElement(buttonsPage.clickButton).click();
        String clickMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id = 'dynamicClickMessage']"))).getText();

        Assertions.assertEquals(clickMessage, "You have done a dynamic click");
    }

}

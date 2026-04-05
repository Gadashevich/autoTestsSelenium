package evgeniy.pageTest;

import evgeniy.pageObject.LinksPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LinksTest {
    WebDriver webDriver;
    LinksPage linksPage;
    WebDriverWait wait;

    @BeforeEach
    void start() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        linksPage = new LinksPage();
        webDriver.get("https://demoqa.com/links");
    }

    @AfterEach
    void end() {
        webDriver.close();
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    void checkHomeLink() {
        String originalWindow = webDriver.getWindowHandle();

        webDriver.findElement(linksPage.homeLink).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        webDriver.getWindowHandles().stream()
                .filter(h -> !h.equals(originalWindow))
                .findFirst()
                .ifPresent(h -> webDriver.switchTo().window(h));

        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/"));
        Assertions.assertEquals("https://demoqa.com/", webDriver.getCurrentUrl());
    }

    @Test
    void checkDynamicLink() {
        String originalWindow = webDriver.getWindowHandle();
        webDriver.findElement(linksPage.dynamicLink).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        webDriver.getWindowHandles().stream()
                .filter(h -> !h.equals(originalWindow))
                .findFirst()
                .ifPresent(h -> webDriver.switchTo().window(h));

        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/"));
        Assertions.assertEquals("https://demoqa.com/", webDriver.getCurrentUrl());
    }

    @Test
    void checkCreatedLink() {
        webDriver.findElement(linksPage.createdLink).click();

        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String fullText = responseElement.getText();

        Assertions.assertTrue(fullText.contains("Link has responded with staus"));
        Assertions.assertTrue(fullText.contains("201"));
        Assertions.assertTrue(fullText.contains("Created"));
    }

    @Test
    void checkNoContentLink() {
        webDriver.findElement(linksPage.noContentLink).click();

        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String fullText = responseElement.getText();

        Assertions.assertTrue(fullText.contains("Link has responded with staus"));
        Assertions.assertTrue(fullText.contains("204"));
        Assertions.assertTrue(fullText.contains("No Content"));
    }


    @Test
    void checkMovedLinkLink() {
        webDriver.findElement(linksPage.movedLink).click();

        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String fullText = responseElement.getText();

        Assertions.assertTrue(fullText.contains("Link has responded with staus"));
        Assertions.assertTrue(fullText.contains("301"));
        Assertions.assertTrue(fullText.contains("Moved Permanently"));
    }

    @Test
    void checkBadRequestLink() {
        webDriver.findElement(linksPage.badRequestLink).click();

        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String fullText = responseElement.getText();

        Assertions.assertTrue(fullText.contains("Link has responded with staus"));
        Assertions.assertTrue(fullText.contains("400"));
        Assertions.assertTrue(fullText.contains("Bad Request"));
    }

    @Test
    void checkUnauthorizedLink() {
        webDriver.findElement(linksPage.unauthorizedLink).click();

        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String fullText = responseElement.getText();

        Assertions.assertTrue(fullText.contains("Link has responded with staus"));
        Assertions.assertTrue(fullText.contains("401"));
        Assertions.assertTrue(fullText.contains("Unauthorized"));
    }

    @Test
    void checkForbiddenLink() {
        webDriver.findElement(linksPage.forbiddenLink).click();

        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String fullText = responseElement.getText();

        Assertions.assertTrue(fullText.contains("Link has responded with staus"));
        Assertions.assertTrue(fullText.contains("403"));
        Assertions.assertTrue(fullText.contains("Forbidden"));
    }

    @Test
    void checkInvalidLink() {
        webDriver.findElement(linksPage.invalidLink).click();

        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String fullText = responseElement.getText();

        Assertions.assertTrue(fullText.contains("Link has responded with staus"));
        Assertions.assertTrue(fullText.contains("404"));
        Assertions.assertTrue(fullText.contains("Not Found"));
    }

}
package evgeniy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TextBoxPage {
    public WebDriver webDriver;
    public WebDriverWait wait;

    By inputNameLocator = By.xpath("//input[@id='userName']");
    By inputEmailLocator = By.xpath("//input[@id='userEmail']");
    By inputCurrentAddressLocator = By.xpath("//textarea[@id='currentAddress']");
    By inputPermanentLocator = By.xpath("//textarea[@id='permanentAddress']");
    By buttonSubmitLocator = By.xpath("//button[@id='submit']");
    By buttonHeaderNameLocator = By.xpath("//*[@id='root']/header/a/img");
    By getPageName = By.xpath("//div/h1[text()='Text Box']");
    By getNameLocator = By.xpath("//p[@id='name']");
    By getEmailLocator = By.xpath("//p[@id='email']");
    By getCurrentLocator = By.xpath("//p[@id='currentAddress']");
    By getPermanentLocator = By.xpath("//p[@id='permanentAddress']");

    public TextBoxPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public String getPageName() {
        return webDriver.findElement(getPageName).getText();
    }

    public TextBoxPage setInputName(String text) {
        WebElement element = webDriver.findElement(inputNameLocator);
        element.sendKeys(text);
        return this;
    }

    public String getName() {
        return webDriver.findElement(getNameLocator).getText();
    }


    public TextBoxPage setInputEmail(String text) {
        WebElement element = webDriver.findElement(inputEmailLocator);
        element.sendKeys(text);
        return this;
    }

    public String getEmail() {
        return webDriver.findElement(getEmailLocator).getText();
    }


    public TextBoxPage setInputCurrentAddress(String text) {
        WebElement element = webDriver.findElement(inputCurrentAddressLocator);
        element.sendKeys(text);
        return this;
    }

    public String getCurrentAddress() {
        return webDriver.findElement(getCurrentLocator).getText();
    }

    public TextBoxPage setInputPermanentAddress(String text) {
        WebElement element = webDriver.findElement(inputPermanentLocator);
        element.sendKeys(text);
        return this;
    }

    public String getPermanentAddress() {
        return webDriver.findElement(getPermanentLocator).getText();
    }


    public TextBoxPage setSubmit() {
        WebElement element = webDriver.findElement(buttonSubmitLocator);
        element.click();
        return this;
    }

    public TextBoxPage setHeaderButton() {
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonHeaderNameLocator));
        element.click();
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/"));
        return this;
    }

}
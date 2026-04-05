package evgeniy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage extends BaseElement {
    WebDriver webDriver;
    WebDriverWait wait;

    public By getHeaderName = By.xpath("//h1[@class = 'text-center']");
    public By inputRadioButtonYes = By.xpath("//input[@id ='yesRadio']");
    public By inputRadioButtonImpressive = By.xpath("//input[@id ='impressiveRadio']");
    public By inputRadioButtonNo = By.xpath("//input[@id ='noRadio']");


    public RadioButtonPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }


}

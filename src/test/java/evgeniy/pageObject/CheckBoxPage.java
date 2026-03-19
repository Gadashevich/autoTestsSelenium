package evgeniy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckBoxPage {
    WebDriver webDriver;
    WebDriverWait wait;
    //как лучше группировать xPath по структуре дерева, или группировать их по общим признакам ?

    By switcherHome = By.xpath("//span[@title='Home']/preceding-sibling::span[contains(@class,'switcher')]");
    By switcherDesktop = By.xpath("//span[@title='Desktop']/preceding-sibling::span[contains(@class,'switcher')]");
    By switcherDocuments = By.xpath("//span[@title='Documents']/preceding-sibling::span[contains(@class,'switcher')]");
    By switcherDownloads = By.xpath("//span[@title='Downloads']/preceding-sibling::span[contains(@class,'switcher')]");
    By switcherDocumentsWorkSpace = By.xpath("//span[@title='WorkSpace']/preceding-sibling::span[contains(@class,'switcher')]");
    By switcherDocumentsOffice = By.xpath("//span[@title='Office']/preceding-sibling::span[contains(@class,'switcher')]");

    By checkBoxHome = By.xpath("//span[@title='Home']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDesktop = By.xpath("//span[@title='Desktop']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDocuments = By.xpath("//span[@title='Documents']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDownloads = By.xpath("//span[@title='Downloads']/preceding-sibling::span[contains(@class,'checkbox')]");

    By checkBoxDesktopNotes = By.xpath("//span[@title='Notes']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDesktopCommands = By.xpath("//span[@title='Commands']/preceding-sibling::span[contains(@class,'checkbox')]");

    By checkBoxDocumentsWorkSpaceReact = By.xpath("//span[@title='React']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDocumentsWorkSpaceAngular = By.xpath("//span[@title='Angular']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDocumentsWorkSpaceVeu = By.xpath("//span[@title='Veu']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDocumentsOfficePublic = By.xpath("//span[@title='Public']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDocumentsOfficePrivate = By.xpath("//span[@title='Private']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDocumentsOfficeClassified = By.xpath("//span[@title='Classified']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDocumentsOfficeGeneral = By.xpath("//span[@title='General']/preceding-sibling::span[contains(@class,'checkbox')]");

    By checkBoxDownloadsWordFile = By.xpath("//span[@title='Word File.doc']/preceding-sibling::span[contains(@class,'checkbox')]");
    By checkBoxDownloadsExcelFile = By.xpath("//span[@title='Excel File.doc']/preceding-sibling::span[contains(@class,'checkbox')]");


    public CheckBoxPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public CheckBoxPage setSwitcherHome() {
        WebElement element = webDriver.findElement(switcherHome);
        element.click();
        return this;
    }

    public CheckBoxPage setSwitcherDesktop() {
        WebElement element = webDriver.findElement(switcherDesktop);
        element.click();
        return this;
    }

    public CheckBoxPage setSwitcherDocuments() {
        WebElement element = webDriver.findElement(switcherDocuments);
        element.click();
        return this;
    }

    public CheckBoxPage setSwitcherDocumentsWorkSpace() {
        WebElement element = webDriver.findElement(switcherDocumentsWorkSpace);
        element.click();
        return this;
    }

    public CheckBoxPage setSwitcherDocumentsOffice() {
        WebElement element = webDriver.findElement(switcherDocumentsOffice);
        element.click();
        return this;
    }


    public CheckBoxPage setSwitcherDownloads() {
        WebElement element = webDriver.findElement(switcherDownloads);
        element.click();
        return this;
    }


    public CheckBoxPage setCheckBoxHome() {
        WebElement element = webDriver.findElement(checkBoxHome);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDesktop() {
        WebElement element = webDriver.findElement(checkBoxDesktop);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocuments() {
        WebElement element = webDriver.findElement(checkBoxDocuments);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDownloads() {
        WebElement element = webDriver.findElement(checkBoxDownloads);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDesktopNotes() {
        WebElement element = webDriver.findElement(checkBoxDesktopNotes);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDesktopCommands() {
        WebElement element = webDriver.findElement(checkBoxDesktopCommands);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocumentsWorkSpaceReact() {
        WebElement element = webDriver.findElement(checkBoxDocumentsWorkSpaceReact);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocumentsWorkSpaceAngular() {
        WebElement element = webDriver.findElement(checkBoxDocumentsWorkSpaceAngular);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocumentsWorkSpaceVeu() {
        WebElement element = webDriver.findElement(checkBoxDocumentsWorkSpaceVeu);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocumentsOfficePublic() {
        WebElement element = webDriver.findElement(checkBoxDocumentsOfficePublic);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocumentsOfficePrivate() {
        WebElement element = webDriver.findElement(checkBoxDocumentsOfficePrivate);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocumentsOfficeClassified() {
        WebElement element = webDriver.findElement(checkBoxDocumentsOfficeClassified);
        element.click();
        return this;
    }

    public CheckBoxPage setCheckBoxDocumentsOfficeGeneral() {
        WebElement element = webDriver.findElement(checkBoxDocumentsOfficeGeneral);
        element.click();
        return this;
    }


    public CheckBoxPage setCheckBoxDownloadsWordFile() {
        WebElement element = webDriver.findElement(checkBoxDownloadsWordFile);
        element.click();
        return this;
    }


    public CheckBoxPage setCheckBoxDownloadsExcelFile() {
        WebElement element = webDriver.findElement(checkBoxDownloadsExcelFile);
        element.click();
        return this;
    }


    public Boolean getVisibilityDesktop() {
        return !wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@title ='Desktop']")));
    }

    public Boolean checkInvisible(String name) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.format("//span[@title ='%s']", name))));
    }

    public Boolean checkVisible(String name) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//span[@title ='%s']", name)))).isDisplayed();
    }

}


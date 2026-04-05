package evgeniy.pageObject;

import org.openqa.selenium.By;

public class ButtonsPage {

    public By doubleClickButton = By.xpath("//button[@id ='doubleClickBtn']");
    public By rightClickButton = By.xpath("//button[@id ='rightClickBtn']");
    public By clickButton = By.xpath("//button[text()='Click Me']");

}

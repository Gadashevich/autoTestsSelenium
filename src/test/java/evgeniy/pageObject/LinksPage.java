package evgeniy.pageObject;

import org.openqa.selenium.By;

public class LinksPage {
    public By homeLink = By.xpath("//a[@id='simpleLink']");
    public By dynamicLink = By.xpath("//a[@id='dynamicLink']");

    public By createdLink = By.xpath("//a[@id ='created']");
    public By noContentLink = By.xpath("//a[@id ='no-content']");
    public By movedLink = By.xpath("//a[@id ='moved']");
    public By badRequestLink = By.xpath("//a[@id ='bad-request']");
    public By unauthorizedLink = By.xpath("//a[@id ='unauthorized']");
    public By forbiddenLink = By.xpath("//a[@id ='forbidden']");
    public By invalidLink = By.xpath("//a[@id ='invalid-url']");
}

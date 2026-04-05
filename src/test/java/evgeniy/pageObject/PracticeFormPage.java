package evgeniy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormPage extends BaseElement {

    public By inputFistNameLocator = By.xpath("//input[@id ='firstName']");
    public By inputLastNameLocator = By.xpath("//input[@id ='lastName']");
    public By inputEmailLocator = By.xpath("//input[@id ='userEmail']");

    public By inputGenderMaleButton = By.xpath("//input[@id ='gender-radio-1']");
    public By inputGenderFemaleButton = By.xpath("//input[@id ='gender-radio-2']");
    public By inputGenderOtherButton = By.xpath("//input[@id ='gender-radio-3']");

    public By inputMobileLocator = By.xpath("//input[@id ='userNumber']");
    public By inputDateOfBirthLocator = By.xpath("//input[@id ='dateOfBirthInput']");
    public By inputSubjectsLocator = By.xpath("//input[@id ='subjects-label']");

    public By inputHobbiesSportsButton = By.xpath("//input[@id ='hobbies-checkbox-1']");
    public By inputReadingButton = By.xpath("//input[@id ='hobbies-checkbox-2']");
    public By inputMusicButton = By.xpath("//input[@id ='hobbies-checkbox-3']");

    public By inputPictureButton = By.xpath("//input[@id ='uploadPicture']");
    public By inputCurrentLocator = By.xpath("//textarea[@id ='currentAddress']");
    public By inputStateAndCityLocator = By.xpath("//div[@class = 'css-19bb58m']");

    public By submitButton = By.xpath("//button[@id ='submit']");



    public void setFirstName(String name) {
        WebElement fistName = webDriver.findElement(inputFistNameLocator);
        fistName.click();
        fistName.sendKeys(name);
    }

    public void setLastName(String name) {
        WebElement fistName = webDriver.findElement(inputLastNameLocator);
        fistName.click();
        fistName.sendKeys(name);
    }

    public void setEmail(String name) {
        WebElement fistName = webDriver.findElement(inputEmailLocator);
        fistName.click();
        fistName.sendKeys(name);
    }

    public void setGender(String gender) {
        gender = gender.toLowerCase();
        switch (gender) {
            case "male":
                webDriver.findElement(inputGenderMaleButton).click();
            case "female":
                webDriver.findElement(inputGenderFemaleButton).click();
            case "other":
                webDriver.findElement(inputGenderOtherButton).click();
        }
    }

    public void setMobileNumber(int number) {
        if (String.valueOf(number).length() < 10) System.out.println("Введен не корректный номер");
        WebElement element = webDriver.findElement(inputMobileLocator);
        element.click();
        element.sendKeys(String.valueOf(number));
    }

    public void setDateOfBirth(String date) {
        webDriver.findElement(inputDateOfBirthLocator).sendKeys(date);
    }


}

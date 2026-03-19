package evgeniy.pageObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class TextBoxTest extends BaseElement {

    TextBoxPage textBoxPage;

    @Override
    @BeforeEach
    public void setup() {
        super.setup();
        textBoxPage = new TextBoxPage(webDriver, new WebDriverWait(webDriver,Duration.ofSeconds(5)));
        webDriver.get("http://demoqa.com/text-box");
    }

    @AfterEach
    public void after() {
        webDriver.close();
    }


    @Test
    public void testPageElements() {
        textBoxPage.setInputName("Пётр")
                .setInputEmail("petr@mail.ru")
                .setInputCurrentAddress("currentAdd")
                .setInputPermanentAddress("permanentAdd")
                .setSubmit();

        Assertions.assertEquals(textBoxPage.getName(), "Name:Пётр");
        Assertions.assertEquals(textBoxPage.getEmail(), "Email:petr@mail.ru");
        Assertions.assertEquals(textBoxPage.getCurrentAddress(), "Current Address :currentAdd");
        Assertions.assertEquals(textBoxPage.getPermanentAddress(), "Permananet Address :permanentAdd");

    }

    @Test
    public void testPageElementsIsNull() {
        textBoxPage.setInputName("")
                .setInputEmail("")
                .setInputCurrentAddress("")
                .setInputPermanentAddress("")
                .setSubmit();

        Assertions.assertThrows(org.openqa.selenium.NoSuchElementException.class, () -> {
            textBoxPage.getName();
        });
        Assertions.assertThrows(org.openqa.selenium.NoSuchElementException.class, () -> {
            textBoxPage.getEmail();
        });
        Assertions.assertThrows(org.openqa.selenium.NoSuchElementException.class, () -> {
            textBoxPage.getCurrentAddress();
        });
        Assertions.assertThrows(org.openqa.selenium.NoSuchElementException.class, () -> {
            textBoxPage.getPermanentAddress();
        });
    }

    @Test
    public void testPageElementsIsBlank() {
        textBoxPage.setInputName(" ")
                .setInputEmail("   ")
                .setInputCurrentAddress(" \t")
                .setInputPermanentAddress(" \n")
                .setSubmit();

        Assertions.assertEquals(textBoxPage.getName(), "Name:");
        Assertions.assertThrows(org.openqa.selenium.NoSuchElementException.class, () -> {
            textBoxPage.getEmail();
        });
        Assertions.assertEquals(textBoxPage.getCurrentAddress(), "Current Address :");
        Assertions.assertEquals(textBoxPage.getPermanentAddress(), "Permananet Address :");

    }

    @Test
    public void testPageName() {
        String pageName = textBoxPage.getPageName();

        Assertions.assertEquals(pageName, "Text Box");
    }

    @Test
    public void testHeaderElement() throws InterruptedException {
        textBoxPage.setHeaderButton();

        Assertions.assertEquals(webDriver.getCurrentUrl(), "https://demoqa.com/");
    }


}

package evgeniy.pageTest;

import evgeniy.pageObject.BaseElement;
import evgeniy.pageObject.CheckBoxPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CheckBoxTest extends BaseElement {
    CheckBoxPage checkBoxPage;
    WebDriverWait wait;
    boolean status;

    @Override
    @BeforeEach
    public void setup() {
        super.setup();
        checkBoxPage = new CheckBoxPage(webDriver, new WebDriverWait(webDriver, Duration.ofSeconds(5)));
        webDriver.get("https://demoqa.com/checkbox");

    }

    @AfterEach
    public void after() {
        webDriver.close();
    }

    @Test
    public void switcherHomeTestNOTWORK() {
        boolean isVisibility = checkBoxPage.getVisibilityDesktop();
        Assertions.assertFalse(isVisibility);

        checkBoxPage.setSwitcherHome();

        isVisibility = checkBoxPage.getVisibilityDesktop();

        Assertions.assertTrue(isVisibility);
    }

    @Test
    public void switcherHomeTest() {
        status = checkBoxPage.checkInvisible("Desktop");
        Assertions.assertTrue(status);

        checkBoxPage.setSwitcherHome();

        status = checkBoxPage.checkVisible("Desktop");
        Assertions.assertTrue(status);
    }


    @Test
    public void switcherDesktopTest() {
        checkBoxPage.setSwitcherHome();

        status = checkBoxPage.checkInvisible("Notes");
        Assertions.assertTrue(status);

        checkBoxPage.setSwitcherDesktop();

        status = checkBoxPage.checkVisible("Notes");
        Assertions.assertTrue(status);
    }

    @Test
    public void switcherDocumentsTest() {
        checkBoxPage.setSwitcherHome();

        status = checkBoxPage.checkInvisible("WorkSpace");
        Assertions.assertTrue(status);

        checkBoxPage.setSwitcherDocuments();

        status = checkBoxPage.checkVisible("WorkSpace");
        Assertions.assertTrue(status);
    }

    @Test
    public void switcherDownloadsTest() {
        checkBoxPage.setSwitcherHome();

        status = checkBoxPage.checkInvisible("Word File.doc");
        Assertions.assertTrue(status);

        checkBoxPage.setSwitcherDownloads();

        status = checkBoxPage.checkVisible("Word File.doc");
        Assertions.assertTrue(status);
    }

    @Test
    public void switcherDocumentsWorkSpaceTest() {
        checkBoxPage.setSwitcherHome();
        checkBoxPage.setSwitcherDocuments();

        status = checkBoxPage.checkInvisible("React");
        Assertions.assertTrue(status);

        checkBoxPage.setSwitcherDocumentsWorkSpace();

        status = checkBoxPage.checkVisible("React");
        Assertions.assertTrue(status);
    }

    @Test
    public void switcherDocumentsOfficeTest() {
        checkBoxPage.setSwitcherHome();
        checkBoxPage.setSwitcherDocuments();

        status = checkBoxPage.checkInvisible("Public");
        Assertions.assertTrue(status);

        checkBoxPage.setSwitcherDocumentsOffice();

        status = checkBoxPage.checkVisible("Public");
        Assertions.assertTrue(status);
    }


    @Test
    public void setCheckBoxHome() {
        checkBoxPage.setCheckBoxHome();
        List<WebElement> elements = webDriver.findElements(By.xpath("//div[@id='result']/span[@class='text-success']"));

        List<String> collect = elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assertions.assertTrue(collect.contains("home"));
        Assertions.assertTrue(collect.contains("notes"));
        Assertions.assertTrue(collect.contains("workspace"));
        Assertions.assertTrue(collect.contains("react"));
        Assertions.assertTrue(collect.contains("wordFile"));
    }

    @Test
    public void setCheckBoxDocuments() {
        checkBoxPage.setSwitcherHome();
        checkBoxPage.setSwitcherDocuments();
        checkBoxPage.setCheckBoxDocumentsOffice();

        List<WebElement> elements = webDriver.findElements(By.xpath("//span[@class='text-success']"));

        List<String> collect = elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assertions.assertTrue(collect.contains("office"));
        Assertions.assertTrue(collect.contains("public"));
        Assertions.assertTrue(collect.contains("general"));
    }

}


package evgeniy.pageObject;

import org.example.File1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class FileUploadDemoQa {

    @ParameterizedTest()
    @CsvSource({
            "testUpload.txt", "file1.json"
    })
    public void uploadFileTest(String fileName) throws URISyntaxException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/upload-download");


        //  String filePath = Paths.get("testUpload.txt").toAbsolutePath().toString();
        String filePath = Paths.get(getClass().getClassLoader().getResource("files/" + fileName).toURI()).toAbsolutePath().toString();

        WebElement element = webDriver.findElement(By.xpath("//input[@id='uploadFile']"));

        element.sendKeys(filePath);

    }

    @ParameterizedTest()
    @MethodSource("evgeniy.dataTest.DataUtils#getFiles")
    public void uploadFileTestWithResource(File1 file1) throws URISyntaxException {
        // WebDriver webDriver = new ChromeDriver();
        // webDriver.get("https://demoqa.com/upload-download");
        System.out.println(file1.getName());

        //  String filePath = Paths.get("testUpload.txt").toAbsolutePath().toString();
        // String filePath = Paths.get(getClass().getClassLoader().getResource("files/" + file1.getName()).toURI()).toAbsolutePath().toString();

        // WebElement element = webDriver.findElement(By.xpath("//input[@id='uploadFile']"));

        //  element.sendKeys(filePath);

    }
}

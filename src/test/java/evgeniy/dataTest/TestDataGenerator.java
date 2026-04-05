package evgeniy.dataTest;

import org.example.File1;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    File1 file1;
    File1 file2;
    ObjectMapper objectMapper = new ObjectMapper();
    List<File1> listFiles = new ArrayList<>();

    public TestDataGenerator() {
        init();
    }

    public void init() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/file1.json");
             InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream("files/file2.json");
             InputStream inputStreamList = getClass().getClassLoader().getResourceAsStream("files/files.json")
        ) {
            file1 = objectMapper.readValue(inputStream, File1.class);
            file2 = objectMapper.readValue(inputStream2, File1.class);
            listFiles = objectMapper.readValue(inputStreamList, new TypeReference<List<File1>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

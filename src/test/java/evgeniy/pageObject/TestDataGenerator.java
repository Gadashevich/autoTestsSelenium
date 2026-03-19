package evgeniy.pageObject;

import org.example.File1;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestDataGenerator {

    File1 file1;
    ObjectMapper objectMapper = new ObjectMapper();

    public void init() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file1.json")) {
            file1 = objectMapper.readValue(inputStream, File1.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

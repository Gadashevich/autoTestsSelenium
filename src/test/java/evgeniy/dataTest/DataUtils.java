package evgeniy.dataTest;

import org.example.File1;

import java.util.stream.Stream;

public class DataUtils {
    public static TestDataGenerator testDataGenerator = new TestDataGenerator();

    public static Stream<File1> getFiles() {
        return Stream.of(testDataGenerator.file1,testDataGenerator.file2);

    }

}

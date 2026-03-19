package evgeniy;

import org.example.StringProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringProcessorTest {
    StringProcessor stringProcessor;

    @BeforeEach
    void start() {
        stringProcessor = new StringProcessor();
    }

    @ParameterizedTest()
    @CsvSource({
             "'hello world', 'dlrow olleh'"

    })
    void testReverse(String string, String reverse) {
        String expected = new StringBuilder(string).reverse().toString();
    //    String reverse = stringProcessor.reverse(string);


        Assertions.assertEquals(expected,reverse);
    }


    //        Требования к тестам
//        Покрытие методов
//        Напишите тесты для всех пяти методов класса: reverse, isPalindrome, countVowels, doubleString, removeWhitespace.
//
//                Обычные сценарии
//        Проверьте работу методов с обычными входными данными (непустые строки, смешанный регистр, наличие пробелов).
//
//                Граничные случаи
//        Обязательно протестируйте:
//
//        Пустую строку "".
//
//                Строку из одного символа.
//
//                Строку, состоящую только из пробелов (например, " ").
//
//                Обработка исключений
//        Методы должны выбрасывать IllegalArgumentException при передаче null. Напишите тесты, которые проверяют, что исключение действительно выбрасывается (используйте assertThrows).
//
//
//
//
//
//
//


}

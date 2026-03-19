package org.example;

public class StringProcessor {

    /* Возвращает строку, записанную в обратном порядке.
     * @param s входная строка (не null)
     * @return перевёрнутая строка
     * @throws IllegalArgumentException если аргумент null
                    */
            public String reverse(String s) {
                if (s == null) throw new IllegalArgumentException("String cannot be null");
                return new StringBuilder(s).reverse().toString();
            }

    /* Проверяет, является ли строка палиндромом (игнорируя пробелы и регистр).
                    * @param s входная строка (не null)
     * @return true, если строка палиндром, иначе false
                    * @throws IllegalArgumentException если аргумент null
                    */
            public boolean isPalindrome(String s) {
                if (s == null) throw new IllegalArgumentException("String cannot be null");
                String cleaned = s.replaceAll("\\s+", "").toLowerCase();
                return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
            }

    /* Подсчитывает количество гласных букв (a, e, i, o, u, y) в строке (регистронезависимо).
                    * @param s входная строка (не null)
     * @return количество гласных
     * @throws IllegalArgumentException если аргумент null
                    */
            public int countVowels(String s) {
                if (s == null) throw new IllegalArgumentException("String cannot be null");
                long count = s.toLowerCase().chars()
                        .filter(c -> "aeiouy".indexOf(c) != -1)
                        .count();
                return (int) count;
            }

    /* Возвращает строку, в которой каждый символ исходной строки удвоен.
                    * Пример: "abc" -> "aabbcc"
                    * @param s входная строка (не null)
     * @return строка с удвоенными символами
     * @throws IllegalArgumentException если аргумент null
                    */
            public String doubleString(String s) {
                if (s == null) throw new IllegalArgumentException("String cannot be null");
                StringBuilder result = new StringBuilder();
                for (char c : s.toCharArray()) {
                    result.append(c).append(c);
                }
                return result.toString();
            }

            /*
             * Удаляет все пробельные символы из строки.
             * @param s входная строка (не null)
             * @return строка без пробелов
             * @throws IllegalArgumentException если аргумент null
             */
            public String removeWhitespace(String s) {
                if (s == null) throw new IllegalArgumentException("String cannot be null");
                return s.replaceAll("\\s+", "");
            }
        }
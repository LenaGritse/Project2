package lesson3;

import java.util.LinkedHashMap;

public class Unique {

    public static void main(String[] args) {

        String[] words = {
                "Красный",
                "Оранжевый",
                "Желтый",
                "Зеленый",
                "Голубой",
                "Синий",
                "Фиолетовый",
                "Красный",
                "Желтый",
                "Зеленый",
                "Зеленый",
                "Красный",
                "Синий",
                "Желтый",
                "Синий"
        };

        LinkedHashMap<String, Integer> doubles = new LinkedHashMap<>();

        for(String word: words) {
            Integer result = doubles.get(word);
            doubles.put(word, result == null ? 1 : result + 1);
        }

        System.out.println(doubles);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "111-11-11");
        phoneBook.add("Иванов", "222-22-22");
        phoneBook.add("Петров", "333-33-33");
        phoneBook.add("Петров", "444-44-44");
        phoneBook.add("Сидоров", "555-55-55");
        phoneBook.add("Сидоров", "666-66-66");

        //phoneBook.info();

        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Сидоров");

    }

}

package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    public HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        ArrayList<String> userPhone = phoneBook.get(name);
        if (userPhone == null) {
            userPhone = new ArrayList<>();
            userPhone.add(phone);
            phoneBook.put(name, userPhone);
        }
        else {
            userPhone.add(phone);
        }
    }

    public void get(String name) {
        System.out.println(name + ": " + phoneBook.get(name));
    }

    public void info() {
        System.out.println(phoneBook);
    }
}

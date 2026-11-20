package java_goit_hw_biliaieva;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Anna", "Bob");
        System.out.println(getOddNames(names));
    }

    public static String getOddNames(List<String> names) {
        String result = "";

        for (int i = 0; i < names.size(); i += 2) {
            if (!result.isEmpty()) {
                result += ", ";
            }
            result += (i + 1) + ". " + names.get(i);
        }

        return result;
    }
}

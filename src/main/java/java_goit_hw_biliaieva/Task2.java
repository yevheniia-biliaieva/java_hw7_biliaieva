package java_goit_hw_biliaieva;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Anna", "Bob");
        System.out.println(getUpperCaseSorted(names));
    }

    public static List<String> getUpperCaseSorted(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}

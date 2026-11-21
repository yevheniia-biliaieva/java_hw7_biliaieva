package java_goit_hw_biliaieva;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Anna", "Bob");
        System.out.println(getOddNames(names));
    }

    public static String getOddNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> (index + 1) + ". " + names.get(index))
                .collect(Collectors.joining(", "));
    }
}

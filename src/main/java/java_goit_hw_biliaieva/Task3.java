package java_goit_hw_biliaieva;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        String[] values = {"1, 2, 0", "4, 5"};
        System.out.println(sortedNumbers(values));
    }

    public static String sortedNumbers(String[] values) {
        return Arrays.stream(values)
                .flatMap(value -> Arrays.stream(value.split(",")))
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}

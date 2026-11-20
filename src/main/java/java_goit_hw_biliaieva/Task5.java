package java_goit_hw_biliaieva;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        zip(
                Stream.of("A", "B", "C"),
                Stream.of("1", "2", "3", "4"))
                .forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.toList();
        List<T> secondList = second.toList();
        List<T> result = new ArrayList<>();

        int count = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < count; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(i));
        }

        return result.stream();
    }
}

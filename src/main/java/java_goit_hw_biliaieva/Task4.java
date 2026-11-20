package java_goit_hw_biliaieva;

import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        randoms(25214903917L, 11L, 1L << 48)
                .limit(5)
                .forEach(System.out::println);
    }

    public static Stream<Long> randoms(long a, long c, long m) {
        if (m <= 0) {
            throw new IllegalArgumentException("m must be positive");
        }
        long seed = 0;
        return Stream.iterate(seed, x -> {
            long next = (a * x + c) % m;
            if (next < 0) {
                next += m;
            }
            return next;
        });
    }
}

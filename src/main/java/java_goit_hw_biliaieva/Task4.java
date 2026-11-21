package java_goit_hw_biliaieva;

import java.math.BigInteger;
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
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger bigM = BigInteger.valueOf(m);
        return Stream.iterate(seed, x -> {
            return bigA.multiply(BigInteger.valueOf(x))
                    .add(bigC)
                    .mod(bigM)
                    .longValue();
        });
    }
}

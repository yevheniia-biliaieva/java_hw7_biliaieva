package java_goit_hw_biliaieva;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {
    public static void main(String[] args) {
        zip(
                Stream.of("A", "B", "C"),
                Stream.of("1", "2", "3", "4"))
                .forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Iterator<T> zippedIterator = new Iterator<>() {
            private boolean firstTurn = true;

            @Override
            public boolean hasNext() {
                return firstTurn
                        ? firstIterator.hasNext() && secondIterator.hasNext()
                        : secondIterator.hasNext() && firstIterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (firstTurn) {
                    firstTurn = false;
                    return firstIterator.next();
                }

                firstTurn = true;
                return secondIterator.next();
            }
        };

        Spliterator<T> spliterator =
                Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false)
                .onClose(() -> {
                    first.close();
                    second.close();
                });
    }
}

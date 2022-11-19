package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeekSkipExample {

    public static void main(String[] args) {
        // peek example
        // use it to print or Logging elements after some filtering or other operations
        List<String> stringList = Stream.of("One", "Two", "Three")
                .filter(obj -> !obj.equals("One"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("stringList = " + stringList);

        // skip example
        // use it to skip some elements before applying some operations
        IntStream.of(1, 23, 4, 5, 6, 7)
                .skip(1)
                .filter(i -> i > 5)
                .forEach(System.out::println);
    }

}

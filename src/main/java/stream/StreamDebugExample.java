package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDebugExample {

    public static void main(String[] args) {
        /**
         * This example is created to show the debugging process of stream.
         * We can use Java Stream Debugger plugin of Intellij IDEA.
         * Place a debug pointer on the line you want to debug.
         * When debugger reach to that line click on "Trace Current Stream Chain" button on the debugger window.
         * You will see each step details and changes from one step to others.
         * */
        List<String> stringList = Stream.of("How are you?", "I'm fine", "Hello", "Hasan", "Hi", "Awesome")
                .filter(text -> text.contains("H"))
                .map(text -> text.substring(0, Math.min(5, text.length())))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(stringList);
    }

}

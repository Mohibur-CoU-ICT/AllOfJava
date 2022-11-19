package stream;

import java.util.Arrays;
import java.util.List;

public class FilterExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mohibur", "Hasan", "Mojahid", "Mamun", "Anik");

        System.out.println("Imperative style");
        for (String name : names) {
            if (!name.equals("Hasan")) {
                System.out.println(name);
            }
        }

        System.out.println("\nFunctional style");
        System.out.println("\nWithout method reference");
        names.stream()
                .filter(name -> !name.equals("Mamun"))
                .forEach(name -> System.out.println(name));

        System.out.println("\nWith method reference");
        names.stream()
                .filter(FilterExample::isNotHasan)
                .forEach(System.out::println);
    }

    public static boolean isNotHasan(String name) {
        return !name.equals("Hasan");
    }
}

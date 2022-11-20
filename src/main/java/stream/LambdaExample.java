package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LambdaExample {

    public static void main(String[] args) {
        Game football = new Game() {
            @Override
            public void play() {
                System.out.println("I am playing football");
            }
        };
        football.play();

        Game cricket = new Game() {
            @Override
            public void play() {
                System.out.println("I am playing cricket");
            }
        };
        cricket.play();

        Game footballLambda = () -> System.out.println("I am playing football in lambda");
        footballLambda.play();

        Series odiSeries = type -> System.out.println("It's a " + type + " series in lambda");
        odiSeries.play("odi");

        List<String> cities = Arrays.asList("Dhaka", "Chittagong", "Rajshahi", "Khulna", "Barisal", "Rangpur");

        boolean dhakaFound = false;
        for (String city : cities) {
            if (city.equals("Dhaka")) {
                dhakaFound = true;
                System.out.println("Dhaka is present in imperative style");
            }
        }
        if (dhakaFound) {
            System.out.println("Dhaka is present in if condition");
        }

        cities.stream()
                .filter(city -> city.equals("Khulna"))
                .forEach(city -> System.out.println("Khulna is present in functional style"));

        Optional<String> stringOptional = cities.stream()
                .filter(city -> city.equals("Chittagong"))
                .findFirst();

        stringOptional.ifPresent(s -> System.out.println(s + " is present in optional"));
    }

    interface Game {
        void play();
    }

    interface Series {
        void play(String type);
    }

}

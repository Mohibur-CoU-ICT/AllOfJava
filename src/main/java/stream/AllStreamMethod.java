package stream;

import java.util.*;
import java.util.stream.Collectors;

public class AllStreamMethod {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach
        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }

        System.out.println("Females:");
        females.forEach(System.out::println);

        // Declarative approach
        // Filter
        List<Person> females2 = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        System.out.println("\nFemales using filter:");
        females.forEach(System.out::println);

        // Sort
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());

        System.out.println("\nPerson of sorted by age and then gender and then reversed:");
        sortedByAge.forEach(System.out::println);

        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 20);
        System.out.println("\nallMatch = " + allMatch);

        // Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 20);
        System.out.println("\nanyMatch = " + anyMatch);

        // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Mamun"));
        System.out.println("\nnoneMatch = " + noneMatch);

        // Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(person -> System.out.println("\nOldest person = " + person));

        // Min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(person -> System.out.println("\nYoungest person = " + person));

        // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println("\nPersons group by gender:");
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        // find female and then oldest and then return the name
        Optional<String> oldestFemaleName = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleName.ifPresent(person -> System.out.println("\nOldest female = " + person));
    }

    private static List<Person> getPeople() {
        return Arrays.asList(
                new Person("Mohibur", 26, Gender.MALE),
                new Person("Hasan", 25, Gender.MALE),
                new Person("Kheya", 25, Gender.FEMALE),
                new Person("Habiba", 10, Gender.FEMALE),
                new Person("Marjia", 8, Gender.FEMALE),
                new Person("Mojahid", 25, Gender.MALE),
                new Person("Bithi", 25, Gender.FEMALE)
        );
    }

}

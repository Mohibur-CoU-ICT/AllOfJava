package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapperExample {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Mohibur", 26, Arrays.asList("1", "2")),
                new User("Hasan", 25, Arrays.asList("3", "4", "5")),
                new User("Mujahid", 25, Arrays.asList("6", "7")),
                new User("Mamun", 26, Arrays.asList("8", "9"))
        );

        System.out.println("Functional style:");

        Optional<String> stringOptional = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter(phone -> phone.equals("5")))
                .findAny();

        stringOptional.ifPresent(System.out::println);
    }

    public static boolean isNotHasan(String name) {
        return !name.equals("Hasan");
    }

    static class User {
        private String name;
        private Integer age = 30;
        private List<String> phoneNumbers;

        public User(String name, Integer age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

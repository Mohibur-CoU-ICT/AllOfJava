package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mohibur", "Hasan", "Mojahid", "Mamun", "Anik");

        System.out.println("Imperative style");
        for (String name : names) {
            if (!name.equals("Hasan")) {
                User user = new User(name);
                System.out.println(user);
            }
        }

        System.out.println("\nFunctional style");
        names.stream()
                .filter(MapperExample::isNotHasan)
                .map(User::new)
                .forEach(System.out::println);

        // collect filtered users as a list
        List<User> users = names.stream()
                .filter(MapperExample::isNotHasan)
                .map(User::new)
                .collect(Collectors.toList());

        System.out.println("\nUsers = " + users);
    }

    public static boolean isNotHasan(String name) {
        return !name.equals("Hasan");
    }

    static class User {
        private String name;
        private Integer age = 30;

        public User(String name) {
            this.name = name;
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

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

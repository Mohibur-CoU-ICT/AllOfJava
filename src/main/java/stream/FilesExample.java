package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesExample {

    public static void main(String[] args) throws IOException {

        List<String> stringList = Files.lines(Paths.get("pom.xml"))
                .filter(line -> line.contains("artifactId"))
                .map(line -> line.trim()
                        .replaceAll("artifactId", "")
                        .replaceAll("<", "")
                        .replaceAll(">", "")
                        .replaceAll("/", ""))
                .collect(Collectors.toList());

        System.out.println(stringList);
    }

}

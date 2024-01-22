package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class DroneInputReader {

    public static Stream<String> readInputFile() {
        Path path = Paths.get("src/resources/input.txt");
        Stream<String> lines = Stream.empty();
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            System.out.println("Input file not found");
        }

        return lines;
    }
}

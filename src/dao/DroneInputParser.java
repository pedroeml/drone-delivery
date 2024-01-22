package dao;

import model.Drone;
import model.Location;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class DroneInputParser {

    public static ParsedInput parseLines(Stream<String> lines) {
        final List<Drone> drones = new LinkedList<>();
        final List<Location> locations = new LinkedList<>();

        lines.forEach(line -> {
            if (drones.isEmpty()) {
                parseDronesLine(line, drones);
            } else {
                locations.add(parseLocationLine(line));
            }
        });

        return new ParsedInput(drones, locations);
    }

    private static void parseDronesLine(String line, List<Drone> drones) {
        final String[] dronesLine = line.split(",");

        String name = null;
        int capacity;
        for (int i = 0; i < dronesLine.length; i++) {
            if (i % 2 == 0) {
                name = dronesLine[i];
            } else {
                capacity = Integer.parseInt(dronesLine[i]);
                drones.add(new Drone(name, capacity));
            }
        }
    }

    private static Location parseLocationLine(String line) {
        final String[] locationLine = line.split(",");

        return new Location(locationLine[0], Integer.parseInt(locationLine[1]));
    }
}

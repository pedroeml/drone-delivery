import business.TripPlanner;
import dao.DroneInputParser;
import dao.DroneInputReader;
import dao.ParsedInput;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> lines = DroneInputReader.readInputFile();
        ParsedInput parsedInput = DroneInputParser.parseLines(lines);
        TripPlanner planner = new TripPlanner(parsedInput.drones(), parsedInput.locations());
        planner.planTrips();
        planner.displayTrips();
    }
}
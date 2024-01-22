package model;

import java.util.LinkedList;
import java.util.List;

public class Trip {
    public final Drone drone;
    public final List<Location> locations;
    private int currentWeight;

    public Trip(Drone drone) {
        this.drone = drone;
        this.locations = new LinkedList<>();
        this.currentWeight = 0;
    }

    public boolean add(Location location) {
        if (this.currentWeight + location.weight() <= this.drone.capacity()) {
            this.locations.add(location);
            this.currentWeight += location.weight();

            return true;
        }

        return false;
    }

    public void displayTrip() {
        System.out.println("Drone " + this.drone.name());

        for (Location location : this.locations) {
            System.out.print("Location " + location.name() + " ");
        }

        System.out.println();
    }
}

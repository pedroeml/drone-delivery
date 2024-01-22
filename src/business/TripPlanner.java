package business;

import model.Drone;
import model.Location;
import model.Trip;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TripPlanner {
    private final List<Drone> drones;
    private final List<Location> locations;
    private final List<Trip> trips;

    public TripPlanner(List<Drone> drones, List<Location> locations) {
        this.drones = drones;
        this.locations = locations;
        this.trips = new LinkedList<>();
    }

    public void planTrips() {
        if (!trips.isEmpty()) {
            System.out.println("It has already been planned");
            return;
        }

        this.sortLocations();

        Iterator<Drone> it = this.drones.iterator();
        Drone currentDrone = it.hasNext() ? it.next() : null;
        Trip currentTrip = new Trip(currentDrone);

        while (!this.locations.isEmpty()) {
            final Location location = this.locations.getFirst();

            if (!currentTrip.add(location)) {
                this.trips.add(currentTrip);

                if (it.hasNext()) {
                    currentDrone = it.next();
                } else {
                    it = this.drones.iterator();
                    currentDrone = it.next();
                }

                currentTrip = new Trip(currentDrone);
            } else {
                this.locations.removeFirst();
            }
        }

        this.sortTrips();
    }

    private void sortLocations() {
        Comparator<Location> compareByWeight = (l1, l2) -> {
            if (l1.weight() > l2.weight()) {
                return 1;
            } else if (l1.weight() == l2.weight()) {
                return 0;
            }

            return -1;
        };
        this.locations.sort(compareByWeight);
    }

    private void sortTrips() {
        this.trips.sort(Comparator.comparing(t -> t.drone.name()));
    }

    public void displayTrips() {
        for (Trip trip : this.trips) {
            trip.displayTrip();
        }
    }
}

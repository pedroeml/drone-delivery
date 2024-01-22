package dao;

import model.Drone;
import model.Location;

import java.util.List;

public record ParsedInput (List<Drone> drones, List<Location> locations) { }

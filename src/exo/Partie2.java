package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    private static final Function<Trip, String> toCity = trip -> trip.city();
    private static final Function<Trip, String> toDriverId = trip -> trip.driverId();
    private static final ToDoubleFunction<Trip> toPrice = trip -> trip.price();
    private static final ToDoubleFunction<Trip> toDuration = trip -> trip.durationMin();

    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(toCity, Collectors.counting()));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(toDriverId, Collectors.summingDouble(toPrice)));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(toCity, Collectors.averagingDouble(toDuration)));
    }
}

package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie4 {

    private static final ToDoubleFunction<Trip> toPrice = trip -> trip.price();
    private static final Function<Trip, String> toCity = trip -> trip.city();
    private static final Predicate<Trip> isExpensive = trip -> trip.price() > 30;
    private static final Predicate<Trip> isHighRating = trip -> trip.rating() > 4;

    public double totalRevenueSequential(List<Trip> trips) {
        return trips.stream()
                .mapToDouble(toPrice)
                .sum();
    }

    public double totalRevenueParallel(List<Trip> trips) {
        return trips.parallelStream()
                .mapToDouble(toPrice)
                .sum();
    }

    public Map<String, Long> countByCityParallel(List<Trip> trips) {
        return trips.parallelStream()
                .collect(Collectors.groupingBy(toCity, Collectors.counting()));
    }

    public List<Trip> premiumTripsParallel(List<Trip> trips) {
        return trips.parallelStream()
                .filter(isExpensive.and(isHighRating))
                .toList();
    }
}
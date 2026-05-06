package exo;

import models.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Partie3 {

    private static final Comparator<Trip> byPrice = (t1, t2) -> Double.compare(t1.price(), t2.price());
    private static final Comparator<Trip> byRating = (t1, t2) -> Double.compare(t1.rating(), t2.rating());

    public List<Trip> top10ExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .sorted(byPrice.reversed())
                .limit(10)
                .toList();
    }

    public Optional<Trip> bestTrip(List<Trip> trips) {
        return trips.stream()
                .sorted(byRating.reversed())
                .findFirst();
    }
}
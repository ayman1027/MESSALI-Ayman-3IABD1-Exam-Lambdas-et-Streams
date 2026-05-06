package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    private static final Predicate<Trip> isLong = trip -> trip.distanceKm() > 10;
    private static final Predicate<Trip> isExpensive = trip -> trip.price() > 20;
    private static final Predicate<Trip> isBadRating = trip -> trip.rating() < 3;
    private static final Predicate<Trip> isRecent = trip -> {
        LocalDate tripDate = trip.startTime().toLocalDate();
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        return tripDate.equals(today) || tripDate.equals(yesterday);
    };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isLong.and(isExpensive))
                .toList();
    }

    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isBadRating)
                .toList();
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isRecent)
                .toList();
    }
}

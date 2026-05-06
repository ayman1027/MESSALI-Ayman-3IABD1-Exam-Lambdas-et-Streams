import factory.TripFactory;
import models.Trip;
import exo.Partie1;


import java.util.List;

void main() {
    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1 partie1 = new Partie1();

    System.out.println("=== longAndExpensiveTrips ===");
    partie1.longAndExpensiveTrips(trips).forEach(System.out::println);

    System.out.println("=== badTrips ===");
    partie1.badTrips(trips).forEach(System.out::println);

    System.out.println("=== recentTrips ===");
    partie1.recentTrips(trips).forEach(System.out::println);
}
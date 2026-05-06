import factory.TripFactory;
import models.Trip;
import exo.Partie1;
import exo.Partie2;
import exo.Partie3;

import java.util.List;

void main() {
    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1 partie1 = new Partie1();

    System.out.println("longAndExpensiveTrips");
    partie1.longAndExpensiveTrips(trips).forEach(System.out::println);

    System.out.println("badTrips");
    partie1.badTrips(trips).forEach(System.out::println);

    System.out.println("recentTrips");
    partie1.recentTrips(trips).forEach(System.out::println);

    Partie2 partie2 = new Partie2();

    System.out.println("countByCity");
    partie2.countByCity(trips).forEach((city, count) -> System.out.println(city + " : " + count));

    System.out.println("revenueByDriver");
    partie2.revenueByDriver(trips).forEach((driver, revenue) -> System.out.println(driver + " : " + revenue));

    System.out.println("avgDurationByCity");
    partie2.avgDurationByCity(trips).forEach((city, avg) -> System.out.println(city + " : " + avg));

    Partie3 partie3 = new Partie3();

    System.out.println("top10ExpensiveTrips");
    partie3.top10ExpensiveTrips(trips).forEach(System.out::println);

    System.out.println("bestTrip");
    partie3.bestTrip(trips).ifPresent(System.out::println);
}
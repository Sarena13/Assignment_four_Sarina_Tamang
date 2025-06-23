package Gps;

public class KathmanduTrafficValidator implements RouteValidator {

    @Override
    public boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
            throws InvalidRouteException, SameLocationException {
        if (origin.equalsIgnoreCase(destination)) {
            throw new SameLocationException("Origin and destination cannot be the same! Are you just spinning in circles, Damodar?");
        }

        if (distanceKm < 0.1 || distanceKm > 30) {
            throw new InvalidRouteException("Distance " + distanceKm + "km is unrealistic for Kathmandu commute!");
        }

        return true;
    }

    public static void main(String[] args) {
        RouteValidator validator = new KathmanduTrafficValidator();

        try {
            System.out.println(validator.isValidCommuteRoute("Thamel", "Patan", 15));
            System.out.println(validator.isValidCommuteRoute("Kalanki", "Kalanki", 1)); // should throw SameLocationException
        } catch (SameLocationException | InvalidRouteException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}

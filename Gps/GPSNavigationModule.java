package GPS;

public class GPSNavigationModule implements NavigationService {

    @Override
    public void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException {
        System.out.println("Attempting to navigate from " + startPoint + " to " + endPoint + "...");

        if (startPoint.equalsIgnoreCase("Kalanki")) {
            throw new NavigationFailedException("GPS signal lost near Kalanki! Welcome to Kathmandu traffic!");
        }

        try {
            double distance = simulatedDistance(startPoint, endPoint);
            if (validator.isValidCommuteRoute(startPoint, endPoint, distance)) {
                System.out.println("Navigation successful! Estimated time: 20 minutes (or 2 hours depending on traffic).");
            }
        } catch (InvalidRouteException | SameLocationException e) {
            throw new NavigationFailedException("Route validation failed!", e); // chaining
        }
    }

    private double simulatedDistance(String start, String end) {
        return 5.0; // Simulated fixed distance
    }

    public static void main(String[] args) {
        RouteValidator validator = new KathmanduTrafficValidator();
        NavigationService gps = new GPSNavigationModule();

        String[][] testCases = {
            {"Thamel", "Patan"},
            {"Kalanki", "Balaju"},
            {"Baneshwor", "Baneshwor"},
            {"Chabahil", "Kirtipur"}
        };

        for (String[] route : testCases) {
            System.out.println("\n--- New Navigation Attempt ---");
            try {
                gps.navigate(route[0], route[1], validator);
            } catch (NavigationFailedException e) {
                System.out.println("Navigation Failed: " + e.getMessage());
                if (e.getCause() != null) {
                    System.out.println(" Root Cause: " + e.getCause().getMessage());
                }
            }
        }
    }
}

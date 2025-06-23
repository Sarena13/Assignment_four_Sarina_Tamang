package Gps;

public class CommutePlanner {
    public static void planMyCommute(String origin, String destination, RouteValidator validator, NavigationService navigator) {
        System.out.println("Planning your commute from " + origin + " to " + destination + "...");

        try {
            navigator.navigate(origin, destination, validator);
        } catch (NavigationFailedException e) {
            if (e.getCause() != null) {
                System.out.println("Cannot plan: " + e.getCause().getMessage());
            } else {
                System.out.println("Cannot plan: " + e.getMessage());
            }
        } finally {
            System.out.println("Commute planning for " + origin + " to " + destination + " completed.\n");
        }
    }

    public static void main(String[] args) {
        RouteValidator validator = new KathmanduTrafficValidator();
        NavigationService gps = new GPSNavigationModule();

        planMyCommute("Kalanki", "Balaju", validator, gps);     
        planMyCommute("Baneshwor", "Baneshwor", validator, gps); 
        planMyCommute("Thamel", "Patan", validator, gps);        
    }
}

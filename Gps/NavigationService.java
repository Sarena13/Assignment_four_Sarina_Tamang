package Gps;


public interface NavigationService {
   abstract void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException;
}
 
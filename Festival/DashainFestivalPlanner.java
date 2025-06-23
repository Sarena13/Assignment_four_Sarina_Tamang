package Festival;

import java.util.*;

public class DashainFestivalPlanner {

    public static void executeFestivalPlan(List<FestivalActivity> activities) {
        for (FestivalActivity activity : activities) {
            activity.displayOverview();
            try {
                activity.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Planning Warning (Guests): " + e.getMessage());
            } catch (BudgetExceedException e) {
                System.out.println("Planning Warning (Budget): " + e.getMessage());
            } catch (NoRouteException e) {
                System.out.println("Planning Warning (Routes): " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());
            } finally {
                System.out.println("Activity planning attempt for " + activity.activityName + " completed.");
              
            }
        }
    }

    public static void main(String[] args) {
        List<FestivalActivity> activities = new ArrayList<>();

        activities.add(new TikaCeremony(30000, 10, "Grandfather"));
        activities.add(new TikaCeremony(60000, 12, "Grandmother"));
        activities.add(new TikaCeremony(25000, 2, "Uncle"));

        activities.add(new DeusiBhailo(10000, Arrays.asList("h1", "h2"), 4));
        activities.add(new DeusiBhailo(40000, new ArrayList<>(), 5));
        activities.add(new DeusiBhailo(10000, Arrays.asList("hx"), 2));

        System.out.println("Welcome to the Dashain Festival Planner!");
        executeFestivalPlan(activities);
        System.out.println("Festival planning complete. Hope nobody forgot the sel roti!");
    }
}

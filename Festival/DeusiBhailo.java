package Festival;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DeusiBhailo extends FestivalActivity {
    private List<String> plannedRoutes;
    private int numberOfPerformers;

    public DeusiBhailo(double estimatedCost, List<String> plannedRoutes, int numberOfPerformers) {
        super("Deusi Bhailo Program", estimatedCost);
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (plannedRoutes == null || plannedRoutes.isEmpty()) {
            throw new NoRouteException("No routes planned for Deusi Bhailo! Are we just singing in the living room?");
        }
        if (numberOfPerformers < 3) {
            throw new FestivalPlanningException("Need at least 3 performers for a proper Deusi Bhailo!");
        }
        System.out.println("Deusi Bhailo program with " + numberOfPerformers + " performers planned for " + plannedRoutes.size() + " routes!");
    }

    public static void main(String[] args) {
        List<DeusiBhailo> programs = Arrays.asList(
            new DeusiBhailo(15000, Arrays.asList("h1", "h2"), 5), 
            new DeusiBhailo(10000, new ArrayList<>(), 4),                   
            new DeusiBhailo(18000, Arrays.asList("HX"), 2)             
        );

        for (DeusiBhailo program : programs) {
            program.displayOverview();
            try {
                program.planActivity();
            } catch (NoRouteException e) {
                System.err.println("Route Error: " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.err.println("Planning Error: " + e.getMessage());
            }
    
        }
    }
}

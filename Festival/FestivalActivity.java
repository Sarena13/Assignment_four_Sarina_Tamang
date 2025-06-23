package Festival;
public abstract class FestivalActivity {
    protected String activityName;
    protected double estimatedCost;

    public FestivalActivity(String activity, double Cost) {
        this.activityName = activity;
        this.estimatedCost = Cost;
    }

    public abstract void planActivity() throws FestivalPlanningException;

    public void displayOverview() {
        System.out.println("Activity Name: " + activityName);
        System.out.println("Estimated Cost: " + estimatedCost);
    }
}
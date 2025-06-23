package Festival;

public class TikaCeremony extends FestivalActivity {

    private int expectedGuests;
    private String mainFamilyElder;

  
    public TikaCeremony(double estimatedCost, int expectedGuests, String mainFamilyElder) {
        super("Tika Ceremony", estimatedCost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder  = mainFamilyElder;
    }

    
    @Override
    public void planActivity() throws FestivalPlanningException {
        if (expectedGuests < 5) {
            throw new InvalidGuestCountException("Not enough guests for a lively Tika! Is everyone on vacation?");
        }
        if (estimatedCost > 50000) {
            throw new BudgetExceedException("Tika budget too high! Is this for the whole village?");
        }
        System.out.println("Tika ceremony with " + mainFamilyElder
                           + " planned successfully for " + expectedGuests + " guests!");
    }

    public static void main(String[] args) {
        TikaCeremony[] events = {
            new TikaCeremony(10000, 20, "Mina Tamang"),
            new TikaCeremony(30000, 10, "Urmila Theeng"),
            new TikaCeremony(60000, 25, "Sirman Lama"),      // BudgetExceededException
            new TikaCeremony(40000, 3,  "Surya Maya Theeng") // InvalidGuestCountException
        };

        for (TikaCeremony event : events) {
            event.displayOverview();
            try {
                event.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Planning Warning (Guests): " + e.getMessage());
            } catch (BudgetExceedException e) {
                System.out.println("Planning Warning (Budget): " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());
            }
        }
    }
}

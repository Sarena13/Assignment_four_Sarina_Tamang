

import java.util.List;
import java.util.Arrays;

public class AirportArrivalsDataSource extends TouristDataSource {

    public AirportArrivalsDataSource() {
        super("Tribhuvan Airport Arrivals");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        if (sourceName.contains("Tribhuvan") && Math.random() < 0.3) {
            throw new ConnectionLostException("Airport data connection lost! Maybe a pigeon sat on the antenna?");
        }
        return Arrays.asList("Visitor: John Doe, USA", "Visitor: Emily White, UK");
    }

    public static void main(String[] args) {
        TouristDataSource ds = new AirportArrivalsDataSource();
        try {
            System.out.println(ds.fetchData());
        } catch (DataSourceAccessException e) {
            System.out.println("Failed to fetch: " + e.getMessage());
        }
    }
}

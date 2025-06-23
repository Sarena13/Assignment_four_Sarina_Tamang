package tourism;

import java.util.*;

public class UniqueVisitorCounter implements DataProcessor {

    @Override
    public List<String> process(List<String> rawData) throws DataProcessingException {
        if (rawData == null || rawData.isEmpty()) {
            throw new EmptyDataException("No raw data to process! Did all tourists go missing?");
        }

        Set<String> uniqueVisitors = new HashSet<>();
        for (String entry : rawData) {
            String[] parts = entry.split(":");
            if (parts.length > 1) {
                String nameCountry = parts[1].trim().split(",")[0].trim();
                uniqueVisitors.add(nameCountry);
            }
        }

        return List.of("Unique Visitors: " + uniqueVisitors.size());
    }

    public static void main(String[] args) {
        UniqueVisitorCounter counter = new UniqueVisitorCounter();

        try {
            System.out.println(counter.process(Arrays.asList(
                "Visitor: John Doe, USA",
                "Guest: Ram Thapa, NP",
                "Guest: Alice Smith, AU",
                "Visitor: John Doe, USA"
            )));
        } catch (DataProcessingException e) {
            System.out.println("Processing error: " + e.getMessage());
        }
    }
}

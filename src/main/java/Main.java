import java.text.ParseException;

public class Main {
    public static void main (String[] args) throws ParseException {

        //replace fileName with absolute path to placement.csv location
        PlacementsReader placementsReader = new PlacementsReader("/Users/rolandoramirez/IdeaProjects/centro-exercise/src/main/resources/placements.csv");

        //replace filename with absolute path to delivery.csv location
        DeliveryReader deliveryReader = new DeliveryReader("/Users/rolandoramirez/IdeaProjects/centro-exercise/src/main/resources/delivery.csv");

        //creating reportGenerator instance and setting deliveries and placements from readers
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.setDeliveries((deliveryReader.getRecords()));
        reportGenerator.setPlacements((placementsReader.getRecords()));

        //generator will generate a report based on placements and deliveries set above
        reportGenerator.generateReport();

        //enter date range to return totals result
        reportGenerator.getTotalsByDate("11/22/2020", "12/5/2020");
    }
}

import java.text.ParseException;

public class Main {
    public static void main (String[] args) throws ParseException {
        PlacementsReader placementsReader = new PlacementsReader("/Users/rolandoramirez/IdeaProjects/centro-exercise/src/main/resources/placements.csv");
//        placementsReader.printPlacements();

        DeliveryReader deliveryReader = new DeliveryReader("/Users/rolandoramirez/IdeaProjects/centro-exercise/src/main/resources/delivery.csv");
//        deliveryReader.printDelivery();

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.setDeliveries((deliveryReader.getRecords()));
        reportGenerator.setPlacements((placementsReader.getRecords()));
        reportGenerator.generateReport();
        reportGenerator.getTotalsByDate("11/22/2020", "12/5/2020");
    }
}

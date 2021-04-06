public class Main {
    public static void main (String[] args){
        PlacementsReader placementsReader = new PlacementsReader("/Users/rolandoramirez/IdeaProjects/centro-exercise/src/main/resources/placements.csv");
        placementsReader.printPlacements();

        DeliveryReader deliveryReader = new DeliveryReader("/Users/rolandoramirez/IdeaProjects/centro-exercise/src/main/resources/delivery.csv");
        deliveryReader.printDelivery();
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportGenerator {

    private List<Placement> placements;
    private List<Delivery> deliveries;

    public ReportGenerator() {}

    public List<Placement> getPlacements() {
        return placements;
    }
    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void generateReport() throws ParseException {

        int impressionTotal = 0;
        int cost = 0;
        for(Placement placement: placements) {
            //create filtered list of deliveries based on placement ID
            List<Delivery> deliveresByPlacementId = filterDeliveriesById(placement.getId());

            for (Delivery delivery : deliveresByPlacementId) {
                //increment impressions total per impressions value for each delivery
                impressionTotal += delivery.getImpressions();

                //if we've reached the end of our list, calculate report for placement
                if (delivery == deliveresByPlacementId.get(deliveresByPlacementId.size() - 1)) {
                    cost = (impressionTotal * placement.getCpm() / 1000);
                    System.out.println(placement.getName() + " (" + placement.getStart() + "-" + placement.getEnd() + "): " + impressionTotal + " impressions @ $" + placement.getCpm() + " = " + "$" + cost);
                    impressionTotal = 0;
                    cost = 0;
                }
            }
        }
    }

    public void getTotalsByDate(String startDate, String endDate) throws ParseException {

        int totalImpressions = 0;
        int totalCost = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date endDateFormatted = simpleDateFormat.parse(endDate);
        Date startDateFormatted = simpleDateFormat.parse(startDate);

        //iterate through each delivery in the deliveries list
        for(Delivery delivery: deliveries){
            Date deliveryDateFormatted = simpleDateFormat.parse(delivery.getDate());

            //if the delivery is within the start and end date (inclusive), then calculate new impressions and cost total
            if((deliveryDateFormatted.after(startDateFormatted) || deliveryDateFormatted.equals(startDateFormatted)) && (deliveryDateFormatted.before(endDateFormatted) || deliveryDateFormatted.equals(endDateFormatted))){
                totalImpressions += delivery.getImpressions();
                totalCost += (delivery.getImpressions() * getPlacementById(delivery.getPlacementId()).getCpm()) / 1000;
            }
        }

        //when we've reached the end of the list, print out the results
        System.out.println("Total" + " (" + startDate + "-" + endDate + "): " + totalImpressions + " impressions, $" + totalCost);
    }

    private List<Delivery> filterDeliveriesById(int id){
        List<Delivery> result = new ArrayList<>();
        for(Delivery delivery: deliveries){
            //if the delivery's placement ID matches the parameter value, add it to results list
            if(delivery.getPlacementId() == id){
                result.add(delivery);
            }
        }
        return result;
    }

    private Placement getPlacementById(int id){

        Placement result = new Placement();
        for(Placement placement: placements){
            //if the placement's ID matches the parameter value, add it to results list
            if(placement.getId() == id){
                result = placement;
            }
        }

        return result;
    }
}

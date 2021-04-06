import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DeliveryReader {

    public List<Delivery> getRecords() {
        return records;
    }

    private List<Delivery> records;

    public DeliveryReader(String fileName) {
        records = new ArrayList<Delivery>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                Delivery temp = new Delivery();
                temp.setPlacementId(Integer.parseInt(values[0]));
                temp.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(values[1]));
                temp.setImpressions(Integer.parseInt(values[2]));
                records.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void printDelivery(){
        System.out.println("----Deliveries---");
        for(Delivery delivery: records){
            System.out.println("Placement ID: " + delivery.getPlacementId() + ", Date: " + delivery.getDate() + ", Impressions: " + delivery.getImpressions());
        }
    }
}

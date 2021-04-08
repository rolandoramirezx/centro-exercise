import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class PlacementsReader {

    private List<Placement> records;

    public List<Placement> getRecords() {
        return records;
    }

    public PlacementsReader(String fileName) {
        records = new ArrayList<Placement>();

        //try to resolve file path provided
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName));) {
            String[] values = null;

            //iterate through each item in csv and add new placement to records list
            while ((values = csvReader.readNext()) != null) {
                Placement temp = new Placement();
                temp.setId(Integer.parseInt(values[0]));
                temp.setName(values[1]);
                temp.setStart(values[2]);
                temp.setEnd(values[3]);
                temp.setCpm(Integer.parseInt(values[4]));
                records.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public void printPlacements(){
        System.out.println("----Placements---");
        for(Placement placement: records){
            System.out.println("ID: " + placement.getId() + ", Name: " + placement.getName() + ", Start: " + placement.getStart() + ", End: " + placement.getEnd() + ", CPM: " + placement.getCpm());
        }
    }

}

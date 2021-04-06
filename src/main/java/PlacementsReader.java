import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class PlacementsReader {

    public List<Placement> getRecords() {
        return records;
    }

    private List<Placement> records;

    public PlacementsReader(String fileName) {
        records = new ArrayList<Placement>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                Placement temp = new Placement();
                temp.setId(Integer.parseInt(values[0]));
                temp.setName(values[1]);
                temp.setStart(new SimpleDateFormat("dd/MM/yyyy").parse(values[2]));
                temp.setEnd(new SimpleDateFormat("dd/MM/yyyy").parse(values[3]));
                temp.setCpm(Integer.parseInt(values[4]));
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

    public void printPlacements(){
        System.out.println("----Placements---");
        for(Placement placement: records){
            System.out.println("ID: " + placement.getId() + ", Name: " + placement.getName() + ", Start: " + placement.getStart() + ", End: " + placement.getEnd() + ", CPM: " + placement.getCpm());
        }
    }

}

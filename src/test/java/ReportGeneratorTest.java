import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReportGeneratorTest {

    @InjectMocks
    private ReportGenerator reportGenerator;

    @Test
    public void getDeliveriesTest(){
        //creating placements for test case
        List<Delivery> deliveries = new ArrayList<>();
        Delivery delivery = new Delivery();
        delivery.setImpressions(1);
        delivery.setPlacementId(1);
        delivery.setDate("12/12/21");

        reportGenerator.setDeliveries(deliveries);

        //assert the generator is returning list as expected
        Assert.assertEquals(deliveries, reportGenerator.getDeliveries());
    }

    @Test
    public void getPlacementsTest(){
        //creating placements for test case
        List<Placement> placements = new ArrayList<>();
        Placement placement = new Placement();
        placement.setName("name");
        placement.setId(1);
        placement.setCpm(1);
        placement.setStart("12/01/21");
        placement.setEnd("12/31/21");

        reportGenerator.setPlacements(placements);

        //assert the generator is returning list as expected
        Assert.assertEquals(placements, reportGenerator.getPlacements());
    }

    @Test
    public void generatorReportTest() throws ParseException {
        //creating placements for test case
        List<Placement> placements = new ArrayList<>();
        Placement placement = new Placement();
        placement.setName("name");
        placement.setId(1);
        placement.setCpm(1);
        placement.setStart("12/01/21");
        placement.setEnd("12/31/21");

        //creating deliveries for test case
        List<Delivery> deliveries = new ArrayList<>();
        Delivery delivery = new Delivery();
        delivery.setImpressions(1);
        delivery.setPlacementId(1);
        delivery.setDate("12/12/21");

        //setting placements and deliveries in generator
        reportGenerator.setPlacements(placements);
        reportGenerator.setDeliveries(deliveries);

        //make sure generator is able generate report with placements and deliveries set above
        reportGenerator.generateReport();

    }
}

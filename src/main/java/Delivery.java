import java.util.Date;

public class Delivery {

    private int placementId;
    private Date date;
    private int impressions;

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

}

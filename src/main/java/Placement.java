import java.util.Date;

public class Placement {

    private int id;
    private String name;
    private Date start;
    private Date end;
    private int cpm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getCpm() {
        return cpm;
    }

    public void setCpm(int cpm) {
        this.cpm = cpm;
    }
}

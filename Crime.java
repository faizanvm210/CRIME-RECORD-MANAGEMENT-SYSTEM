import java.io.Serializable;
class Crime implements Serializable {
    private int crimeID;
    private String suspectName;
    private String crimeType;
    private String date;
    private String location;
    private String status;

    // Constructor
    public Crime(int id, String name, String type, String date, String location, String status) {
        this.crimeID = id;
        this.suspectName = name;
        this.crimeType = type;
        this.date = date;
        this.location = location;
        this.status = status;
    }

    // Getters & Setters
    public int getCrimeID() { return crimeID; }
    public String getSuspectName() { return suspectName; }
    public String getCrimeType() { return crimeType; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return crimeID + "," + suspectName + "," + crimeType + "," + date + "," + location + "," + status;
    }
}

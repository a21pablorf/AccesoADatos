package org.example;

//Esta clase se deberia llamar lugar
public class Places {
    private String placeName;
    private String longitude;
    private String latitude;
    private String state;
    private String stateAb;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAb() {
        return stateAb;
    }

    public void setStateAb(String stateAb) {
        this.stateAb = stateAb;
    }
}

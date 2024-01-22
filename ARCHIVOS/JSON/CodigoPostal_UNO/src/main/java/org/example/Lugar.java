package org.example;

import java.util.List;

//Esta clase se deberia llamar codigoPostal
public class Lugar {
    private String postCode;
    private String country;
    private String countryAb;

    //Esta lista se debería llamar lugares
    private List<Places> listPlaces;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAb() {
        return countryAb;
    }

    public void setCountryAb(String countryAb) {
        this.countryAb = countryAb;
    }

    public List<Places> getListPlaces() {
        return listPlaces;
    }

    public void setListPlaces(List<Places> listPlaces) {
        this.listPlaces = listPlaces;
    }
}
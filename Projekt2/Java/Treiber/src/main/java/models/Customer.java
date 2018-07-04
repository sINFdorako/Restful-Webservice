package models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Date;

public class Customer {

    private String vorname;
    private String nachname;
    private int id;
    private Date geburtstag;
    private Date updatedAt;

    @JsonCreator
    public Customer
            (@JsonProperty("id") int id,
            @JsonProperty("address") Address address,
            @JsonProperty("vorname") String vorname,
            @JsonProperty("nachname") String nachname,
            @JsonProperty("geburtstag") Date geburtstag,
            @JsonProperty("updatedAt") Date updatedAt)
    {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.updatedAt = updatedAt;
    }

    public Customer(String vorname, String nachname, int id, Date geburtstag, Date updatedAt) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.id = id;
        this.geburtstag = geburtstag;
        this.updatedAt = updatedAt;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getId() {
        return id;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Contract {

    private long Vertragsnummer;
    private String Vertragsart;
    private int id;
    private int jahresbeitrag;
    private Date updatedAt;

    @JsonCreator
    public Contract(@JsonProperty("Vertragsnumer") long Vertragsnummer,
                    @JsonProperty("Vertragsart") String Vertragsart,
                    @JsonProperty("id") int id,
                    @JsonProperty("jahresbeitrag") int jahrsbeitrag,
                    @JsonProperty("updatedAt") Date updatedAt){

        this.Vertragsnummer = Vertragsnummer;
        this.Vertragsart = Vertragsart;
        this.id = id;
        this.jahresbeitrag = jahrsbeitrag;
        this.updatedAt = updatedAt;

    }

    public long getVertragsnummer() {
        return Vertragsnummer;
    }

    public String getVertragsart() {
        return Vertragsart;
    }

    public int getId() {
        return id;
    }

    public int getJahresbeitrag() {
        return jahresbeitrag;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setVertragsnummer(long vertragsnummer) {
        Vertragsnummer = vertragsnummer;
    }

    public void setVertragsart(String vertragsart) {
        Vertragsart = vertragsart;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJahresbeitrag(int jahresbeitrag) {
        this.jahresbeitrag = jahresbeitrag;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

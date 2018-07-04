package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @JsonProperty("strasse") private String strasse;
    @JsonProperty("postleitzahl") private long postleitzahl;
    @JsonProperty("ort") private String ort;

    @JsonCreator
    public Address(@JsonProperty("strasse") String strasse,
                   @JsonProperty("postleitzahl") long postleitzahl,
                   @JsonProperty("ort") String ort){

        this.strasse = strasse;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public long getPostleitzahl() {
        return postleitzahl;
    }

    public String getOrt() {
        return ort;
    }
}

package pl.baksza.praca_domowa_t5_2.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class City {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("findname")
    private String findname;
    @JsonProperty("country")
    private String country;
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("zoom")
    private Integer zoom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public City withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public City withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("findname")
    public String getFindname() {
        return findname;
    }

    @JsonProperty("findname")
    public void setFindname(String findname) {
        this.findname = findname;
    }

    public City withFindname(String findname) {
        this.findname = findname;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public City withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("coord")
    public Coord getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public City withCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

    @JsonProperty("zoom")
    public Integer getZoom() {
        return zoom;
    }

    @JsonProperty("zoom")
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public City withZoom(Integer zoom) {
        this.zoom = zoom;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public City withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", findname='" + findname + '\'' +
                ", country='" + country + '\'' +
                ", coord=" + coord +
                ", zoom=" + zoom +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}


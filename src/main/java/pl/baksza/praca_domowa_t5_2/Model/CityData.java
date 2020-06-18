package pl.baksza.praca_domowa_t5_2.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "city",
        "time",
        "main",
        "wind",
        "clouds",
        "weather"
})
public class CityData {

    @JsonProperty("city")
    private City city;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("weather")
    private List<Weather> weather = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

//    ********************************************************************
    String src;                 // image file

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    public CityData withCity(City city) {
        this.city = city;
        return this;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    public CityData withTime(Integer time) {
        this.time = time;
        return this;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    public CityData withMain(Main main) {
        this.main = main;
        return this;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public CityData withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public CityData withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public CityData withWeather(List<Weather> weather) {
        this.weather = weather;
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

    public CityData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "CityData{" +
                "city=" + city +
                ", time=" + time +
                ", main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", weather=" + weather +
                ", additionalProperties=" + additionalProperties +
                ", src='" + src + '\'' +
                '}';
    }
}


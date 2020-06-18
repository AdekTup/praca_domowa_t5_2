package pl.baksza.praca_domowa_t5_2.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pl.baksza.praca_domowa_t5_2.Model.City;
import pl.baksza.praca_domowa_t5_2.Model.CityData;
import pl.baksza.praca_domowa_t5_2.Model.FindData;
import pl.baksza.praca_domowa_t5_2.Service.WeatherService;

import java.sql.SQLOutput;
import java.util.Optional;

@Controller
public class WeatherController {
    WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeather(Model model) {
        FindData findData = new FindData();
        model.addAttribute("findData",findData);
        return "inCityWeather";
    }

    @PostMapping("/weather")
    public String getCityWeather(FindData findData, Model model) {
        System.out.println("FD: " + findData.getName());

        Optional<FindData>  optionalFindData = weatherService.findCityID(findData.getName());

        System.out.println("OPT FD: " + optionalFindData.get().toString());
        if (!optionalFindData.isEmpty()) {
            RestTemplate restTemplate = new RestTemplate();
            String api_uri = "https://api.openweathermap.org/data/2.5/weather?id=" + Integer.toString(optionalFindData.get().getId()).trim() + "&appid=75b06c0695c8f9827f57991e47c8180d&units=metric";
            CityData cityData = restTemplate.getForObject(api_uri,CityData.class);

//          URL is http://openweathermap.org/img/wn/10d@2x.png
            String image_uri = "https://openweathermap.org/img/wn/" + cityData.getWeather().get(0).getIcon() + ".png";

            City city = new City();
            city.setName(findData.getName());
            cityData.setCity(city);

            cityData.setSrc(image_uri);

            System.out.println("CD: " + cityData.toString());

            model.addAttribute("cityData", cityData);

            return "WeatherInCity";
        }

        return "CityNotFind";
    }

}

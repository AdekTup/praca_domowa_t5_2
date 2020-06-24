package pl.baksza.praca_domowa_t5_2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.baksza.praca_domowa_t5_2.Model.CityData;
import pl.baksza.praca_domowa_t5_2.Model.FindData;
import pl.baksza.praca_domowa_t5_2.Service.WeatherService;
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
//        System.out.println("FD: " + findData.getName());
        Optional<FindData>  optionalFindData = weatherService.findCityID(findData.getName());
        if (!optionalFindData.isEmpty()) {
//            System.out.println("OPT FD: " + optionalFindData.get().toString());
            CityData cityData = weatherService.getDataFromAPI(optionalFindData.get());
            model.addAttribute("cityData", cityData);
            return "WeatherInCity";
        }
        model.addAttribute("findData", findData);
        return "CityNotFind";
    }
}

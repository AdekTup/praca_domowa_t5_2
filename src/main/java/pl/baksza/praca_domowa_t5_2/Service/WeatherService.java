package pl.baksza.praca_domowa_t5_2.Service;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.baksza.praca_domowa_t5_2.Model.City;
import pl.baksza.praca_domowa_t5_2.Model.CityData;
import pl.baksza.praca_domowa_t5_2.Model.FindData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {

    List<FindData> findDataList;

    public WeatherService() {
        this.findDataList = getFindDataList_from_File();
    }

    public List<FindData> getFindDataList() {
        return findDataList;
    }

    public void setFindDataList(List<FindData> findDataList) {
        this.findDataList = findDataList;
    }

    public Optional<FindData> findCityID(String cityName) {
        String findname = cityName.toUpperCase();
        return findDataList.stream().filter(findData -> findData.getFindname().equals(findname)).findFirst();
    }

    private List<FindData> getFindDataList_from_File(){
       List<FindData> findDataList = new ArrayList<>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
//            System.out.println(classLoader.toString());
            InputStream in = classLoader.getResourceAsStream("weather_16_PL_S.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = reader.readLine();
            FindData findData = null;
            ObjectMapper mapper = new ObjectMapper();
            while (line != null) {
                findData = new ObjectMapper().readValue(line, FindData.class);
//                System.out.println(findData.toString());
                findDataList.add(findData);
//                 read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return findDataList;
    }

    public CityData getDataFromAPI(FindData findData) {
        RestTemplate restTemplate = new RestTemplate();
        String api_uri = "https://api.openweathermap.org/data/2.5/weather?id=" + Integer.toString(findData.getId()).trim() + "&appid=75b06c0695c8f9827f57991e47c8180d&units=metric";
        CityData cityData = restTemplate.getForObject(api_uri,CityData.class);
//      Image - URL is http://openweathermap.org/img/wn/10d@2x.png
        String image_uri = "https://openweathermap.org/img/wn/" + cityData.getWeather().get(0).getIcon() + ".png";

        City city = new City();
        city.setName(findData.getName());
        cityData.setCity(city);
        cityData.setSrc(image_uri);
//        System.out.println("CD: " + cityData.toString());
        return cityData;
    }
}

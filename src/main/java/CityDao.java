import java.util.List;

public interface CityDao {
    void createCity(City city);

    City getCityById(int id);

    List<City> getAllCities();

    void updateCityById(int cityId, Employee employee);

    void deleteCityById(City city);
}
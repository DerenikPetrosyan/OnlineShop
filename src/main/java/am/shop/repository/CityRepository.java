package am.shop.repository;

import am.shop.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {

    int countByCity(String city);

    @Override
    List<City> findAll();

    List<City> getByCountryId(int countryid);
}

package am.shop.repository;

import am.shop.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    int countByCountry(String country);

    @Override
    List<Country> findAll();
}

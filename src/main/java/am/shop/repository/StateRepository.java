package am.shop.repository;

import am.shop.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State,Integer> {

    int countByState(String state);

    List<State> getByCountryId(int countryid);

    @Override
    List<State> findAll();
}

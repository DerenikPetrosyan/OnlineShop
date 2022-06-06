package am.shop.service;

import am.shop.model.State;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface StateService {


    State getById(int id) throws NotFoundExcaption;

    List<State> getByAll() throws NotFoundExcaption;

    List<State> getByCountryId(int countryId);

    void crateState(State state) throws DuplicateException, NotFoundExcaption;

    boolean existsById(int id);

    State getStateByState(String state);
}

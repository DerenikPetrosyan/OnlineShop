package am.shop.service.impl;

import am.shop.model.Country;
import am.shop.model.State;
import am.shop.repository.StateRepository;
import am.shop.service.CountryService;
import am.shop.service.StateService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryService countryService;

    @Override
    public State getById(int id) throws NotFoundExcaption {
        State state = stateRepository.findById(id).orElse(null);
        if (state == null) {
            throw new NotFoundExcaption();
        }
        return state;
    }

    @Override
    public List<State> getByAll() throws NotFoundExcaption {

        return stateRepository.findAll();
    }

    @Override
    public List<State> getByCountryId(int countryId) {
        return stateRepository.getByCountryId(countryId);
    }

    @Override
    public void crateState(State state) throws DuplicateException, NotFoundExcaption {
        stateCreationChecks(state);
        stateRepository.save(state);
    }

    private void stateCreationChecks(State state) throws NotFoundExcaption, DuplicateException {
        int dupCount = stateRepository.countByState(state.getState());

        Country country = countryService.getById(state.getCountry().getId());
        if (dupCount > 0) {
            throw new DuplicateException("duplication state");
        } else if (country == null) {
            throw new NotFoundExcaption("not found country");
        }
    }

    @Override
    public boolean existsById(int id ){
        return stateRepository.existsById(id);
    }

    @Override
    public State getStateByState(String state) {
        return stateRepository.getStateByState(state);
    }

}

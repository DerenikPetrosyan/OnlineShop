package am.shop.service.impl;

import am.shop.model.State;
import am.shop.repository.StateRepository;
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

    @Override
    public State getById(int id) throws NotFoundExcaption {
        State state = stateRepository.getById(id);
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
    public void crateState(State state) throws DuplicateException {
        int dupCount = stateRepository.countByState(state.getState());
        if (dupCount > 0) {
            throw new DuplicateException("duplication state");
        }
        stateRepository.save(state);
    }
}

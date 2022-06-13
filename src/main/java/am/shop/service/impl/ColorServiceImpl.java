package am.shop.service.impl;

import am.shop.model.Color;
import am.shop.repository.ColorRepository;
import am.shop.service.ColorService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Color getById(int id) throws NotFoundExcaption {
        return colorRepository.getById(id);
    }

    @Override
    public List<Color> getByAll() throws NotFoundExcaption {
        return colorRepository.findAll();
    }

    @Override
    public void crateColor(Color color) throws DuplicateException {
        if(colorRepository.existsColorByColorName(color.getColorName())){
           throw new DuplicateException();
        }
        colorRepository.save(color);
    }

    @Override
    public void editColor(Color color) throws DuplicateException {
        if(colorRepository.existsColorByColorName(color.getColorName())){
            throw new DuplicateException();
        }
        colorRepository.save(color);
    }
}

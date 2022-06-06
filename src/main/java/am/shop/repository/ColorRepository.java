package am.shop.repository;

import am.shop.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color,Integer> {

    boolean existsColorByColorName(String colorName);
}

package am.shop.repository;

import am.shop.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {

    List<Basket> getByUser(long usrerId);

    @Query(nativeQuery = true,value = "select count from basket where id = ?1")
    int getByCount(long id);

    @Query(nativeQuery = true,value = "select * from basket where user_id = ?1")
    List<Basket> getByUserItems(long usrerId);
}

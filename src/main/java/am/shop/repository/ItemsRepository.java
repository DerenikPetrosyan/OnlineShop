package am.shop.repository;

import am.shop.model.Items;
import am.shop.model.dto.response.ItemsInfoPaser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ItemsRepository extends JpaRepository<Items,Long> {


    @Query(nativeQuery = true, value = "SELECT items.id AS id , items.name AS name , brand.brand_name AS brand ," +
            " category.category_name AS category , price   FROM items " +
            "LEFT JOIN brand ON brand.id = items.brand_id " +
            "LEFT JOIN category ON category.id = items.category_id " +
            " WHERE IF(?1 IS NOT NULL, items.name LIKE CONCAT(?1, '%'), TRUE) " +
            " AND IF(?2 IS NOT NULL, brand.brand_name LIKE CONCAT(?2,'%'),TRUE) " +
            " AND IF(?3 IS NOT NULL, category.category_name LIKE CONCAT(?3,'%'),TRUE)")
    List<ItemsInfoPaser> search(String name, String brand, String category);

    @Query(nativeQuery = true, value = "SELECT items.id AS id , items.name AS name , brand.brand_name AS brand ," +
            " category.category_name AS category, price   FROM items " +
            "LEFT JOIN brand ON brand.id = items.brand_id " +
            "LEFT JOIN category ON category.id = items.category_id " +
            " WHERE price >= ?1")
    List<ItemsInfoPaser> priceExpensive(BigDecimal price);

    @Query(nativeQuery = true, value = "SELECT items.id AS id , items.name AS name , brand.brand_name AS brand ," +
            " category.category_name AS category, price   FROM items " +
            "LEFT JOIN brand ON brand.id = items.brand_id " +
            "LEFT JOIN category ON category.id = items.category_id " +
            " WHERE price <= ?1")
    List<ItemsInfoPaser> priceCheap(BigDecimal price);


    @Query(nativeQuery = true,value = "select * from items ",
            countQuery = "select count(*) from items")
    Page<Items> getItems(Pageable pageable);
}

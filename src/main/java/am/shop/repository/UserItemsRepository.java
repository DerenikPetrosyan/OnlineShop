package am.shop.repository;

import am.shop.model.UserItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserItemsRepository extends JpaRepository<UserItems,Long> {

}

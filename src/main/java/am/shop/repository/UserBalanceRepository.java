package am.shop.repository;

import am.shop.model.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface UserBalanceRepository extends JpaRepository<UserBalance,Long> {

}

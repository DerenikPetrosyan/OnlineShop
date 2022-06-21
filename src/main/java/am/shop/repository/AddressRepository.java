package am.shop.repository;

import am.shop.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Override
    List<Address> findAll();


}

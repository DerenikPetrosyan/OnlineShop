package am.shop.repository;

import am.shop.model.User;
import am.shop.model.dto.response.UserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    User getById(long id);

    User getByEmail(String email);

    @Modifying
    @Query("update User u set u.resetPasswordToken = :resetPasswordToken where u.email = :email")
    void newResetPasswordToken(String email, String resetPasswordToken);

    @Modifying
    @Query("update User u set u.password = :password , u.resetPasswordToken = null where u.email = :email")
    void newPassword(String email, String password);

    @Modifying
    @Query(nativeQuery = true,
            value = "update user set ver_code = null , status = 'ACTIVE' where email = ?1")
    void verify(String email);

    @Query("select new am.shop.model.dto.response.UserResponseDto(u.id,u.firstName,u.lastName,u.email," +
            "u.gender,u.dob,u.status,u.updatedAt,u.address.city.city,u.address.state.state,u.address.country.country," +
            "u.address.zipCode,u.address.address) " +
            "from User u where u.id = ?1 ")
    UserResponseDto getUserInfo(long id);

    @Query("select new am.shop.model.dto.response.UserResponseDto(u.id,u.firstName,u.lastName,u.email," +
            "u.gender,u.dob,u.status,u.updatedAt,u.address.city.city,s.state,u.address.country.country," +
            "u.address.zipCode,u.address.address) " +
            "from User u"+" left JOIN  State  s on (s.id = u.address.state.id)")
    List<UserResponseDto> getAll();


}

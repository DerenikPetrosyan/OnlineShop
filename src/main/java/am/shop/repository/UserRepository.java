package am.shop.repository;

import am.shop.model.User;
import am.shop.model.dto.response.UserInfoParser;
import am.shop.model.dto.response.UserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //there is user in DB
    boolean existsByEmail(String email);

    //get user by id from DB
    User getById(long id);


    //get user by email from DB
    User getByEmail(String email);


    //new reset password token
    @Modifying
    @Query("update User u set u.resetPasswordToken = :resetPasswordToken where u.email = :email")
    void newResetPasswordToken(String email, String resetPasswordToken);

    //crated new password
    @Modifying
    @Query("update User u set u.password = :password , u.resetPasswordToken = null where u.email = :email")
    void newPassword(String email, String password);

    //verify user from DB
    @Modifying
    @Query(nativeQuery = true,
            value = "update user set ver_code = null , status = 'ACTIVE' where email = ?1")
    void verify(String email);


    //get user by id from DB
    @Query("select new am.shop.model.dto.response.UserResponseDto(u.id,u.firstName,u.lastName,u.email," +
            "u.gender,u.dob,u.status,u.updatedAt,u.address.city.city,u.address.state.state,u.address.country.country," +
            "u.address.zipCode,u.address.address) " +
            "from User u where u.id = ?1 ")
    UserResponseDto getUserInfo(long id);


    //get all user from DB
    @Query("select new am.shop.model.dto.response.UserResponseDto(u.id,u.firstName,u.lastName,u.email," +
            "u.gender,u.dob,u.status,u.updatedAt,u.address.city.city,s.state,u.address.country.country," +
            "u.address.zipCode,u.address.address) " +
            "from User u"+" left JOIN  State  s on (s.id = u.address.state.id)")
    List<UserResponseDto> getAll();

   //search user by name and/or surname from DB
    @Query(nativeQuery = true, value = "select id as id, first_name as firstName, last_name as lastName," +
            " email as email from user" +
            " where if(?1 is not null, first_name like concat(?1, '%'), true)" +
            "and if(?2 is not null, last_name like concat(?2,'%'),true)")
    List<UserInfoParser> search(String name, String surname);


}

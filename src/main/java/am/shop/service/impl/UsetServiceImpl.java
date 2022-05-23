package am.shop.service.impl;

import am.shop.model.Role;
import am.shop.model.User;
import am.shop.model.UserRoles;
import am.shop.model.UserStatus;
import am.shop.model.dto.request.UserRequestDto;
import am.shop.model.dto.response.UserResponseDto;
import am.shop.repository.UserRepository;
import am.shop.service.CountryService;
import am.shop.service.StateService;
import am.shop.service.UserService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsetServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;


    @Override
    public User getByUsername(String username) throws NotFoundExcaption {

        User user = userRepository.getByEmail(username);
        if (user == null) {
            throw new NotFoundExcaption();
        }

        return null;
    }


    @Override
    public void createUser(UserRequestDto dto) throws DuplicateException, BadRequestException, NotFoundExcaption {

        userCreationChecks(dto);

        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setDob(dto.getDob());
        user.setGender(dto.getGender());
        user.setStatus(UserStatus.UNVERIFIED);
        user.setAddress(dto.getAddress());
        user.setUpdatedAt(System.currentTimeMillis());



        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRole(UserRoles.CUSTOMER);
        roles.add(role);
        user.setRoles(roles);



        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user.setVerCode(RandomString.make(6));

        user.setAddress(dto.getAddress());

        userRepository.save(user);

    }

    private void userCreationChecks(UserRequestDto dto) throws DuplicateException, BadRequestException, NotFoundExcaption {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateException();
        } else if (dto.getPassword().compareTo(dto.getConfirmPassword()) != 0) {
            throw new BadRequestException();
        } else if (dto.getAddress().getState() != null) {
            if (stateService.getById(dto.getAddress().getState().getId()) == null) {
                throw new NotFoundExcaption("not found state");
            }
        } else if (countryService.getById(dto.getAddress().getCountry().getId()) == null) {
            throw new NotFoundExcaption("not found country");
        }

    }

    @Override
    public UserResponseDto getById(long id) {

        return new UserResponseDto(userRepository.getById(id));
    }

    @Override
    public List<UserResponseDto> getByAll() {
        List<User> users = userRepository.findAllBy();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            UserResponseDto userResponseDto = new UserResponseDto(users.get(i));
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }
}

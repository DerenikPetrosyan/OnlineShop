package am.shop.service.impl;

import am.shop.model.*;
import am.shop.model.dto.request.EditUserDto;
import am.shop.model.dto.request.ResetPasswordDto;
import am.shop.model.dto.request.UserRequestDto;
import am.shop.model.dto.response.UserResponseDto;
import am.shop.repository.UserRepository;
import am.shop.service.UserService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private AddressServiceImpl addressService;

    @Override
    public User getByUsername(String username) throws NotFoundExcaption {

        User user = userRepository.getByEmail(username);
        if (user == null) {
            throw new NotFoundExcaption();
        }

        return user;
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
        role.setId(1);
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
        } else if (addressService.getById(dto.getAddress().getId()) == null) {
            throw new NotFoundExcaption();
        }
//        addressService.addressCreationChecks(dto.getAddress());
    }

    @Override
    public UserResponseDto getUserInfo(long id) {
        return userRepository.getUserInfo(id);
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.getAll();
    }

    @Transactional
    @Override
    public void forgotPassword(String email) throws NotFoundExcaption {

        if (!userRepository.existsByEmail(email)) {
            throw new NotFoundExcaption("not found email");
        } else {
            userRepository.newResetPasswordToken(email, RandomString.make(6));
        }
    }

    @Transactional
    @Override
    public void resetPassword(ResetPasswordDto dto) throws NotFoundExcaption, BadRequestException {

        if (!userRepository.existsByEmail(dto.getEmail())) {
            throw new NotFoundExcaption("not found email");
        } else if (dto.getToken().compareTo(userRepository.getByEmail(dto.getEmail()).getResetPasswordToken()) != 0) {
            throw new BadRequestException("not found token");
        } else if (dto.getNewPassword().compareTo(dto.getConfirmPassword()) != 0) {
            throw new BadRequestException("confirmPassword is not equal to a password");
        } else {
            userRepository.newPassword(dto.getEmail(), passwordEncoder.encode(dto.getNewPassword()));
        }

    }

    @Override
    public void editUser(EditUserDto dto) throws NotFoundExcaption {

        if (userRepository.existsById(dto.getId())) {
            User user = userRepository.getById(dto.getId());

            if (dto.getFirstName() != null) {
                user.setFirstName(dto.getFirstName());
            } else if (dto.getLastName() != null) {
                user.setLastName(dto.getLastName());
            } else if (dto.getGender() != null) {
                user.setGender(dto.getGender());
            } else if (dto.getDob() != 0) {
                user.setDob(dto.getDob());
            } else {
                throw new NotFoundExcaption();
            }

            userRepository.save(user);
        }


    }

    @Transactional(rollbackFor = {BadRequestException.class, NotFoundExcaption.class})
    @Override
    public void verify(String email, String code) throws NotFoundExcaption, BadRequestException {
        User user = getByUsername(email);

        if (user.getVerCode() == null || !user.getVerCode().equals(code)) {
            throw new BadRequestException();
        }
        userRepository.verify(email);

    }

    @Override
    public void changePassword(String emale, String oldPassword, String newPassword) throws BadRequestException {
        User user =userRepository.getByEmail(emale);
        String password =user.getPassword();
        if(password.equals(passwordEncoder.encode(oldPassword))){
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }
        else {
            throw new BadRequestException();
        }
    }
}

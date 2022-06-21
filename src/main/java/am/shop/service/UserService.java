package am.shop.service;


import am.shop.model.User;
import am.shop.model.dto.request.EditUserDto;
import am.shop.model.dto.request.ResetPasswordDto;
import am.shop.model.dto.request.UserRequestDto;
import am.shop.model.dto.response.UserInfoParser;
import am.shop.model.dto.response.UserResponseDto;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;


public interface UserService  {

    User getByUsername(String username) throws NotFoundExcaption;

    void  createUser(UserRequestDto dto) throws DuplicateException, BadRequestException, NotFoundExcaption;

    UserResponseDto getUserInfo(long id);

   List<UserResponseDto>  getAll();


    void forgotPassword(String email) throws NotFoundExcaption;

    void resetPassword(ResetPasswordDto dto) throws NotFoundExcaption, BadRequestException;

    void editUser(EditUserDto dto) throws NotFoundExcaption;

    void verify(String email,String code) throws NotFoundExcaption, BadRequestException;

    void changePassword(String emale, String oldPassword, String newPassword) throws BadRequestException;

    List<UserInfoParser> search(String name, String surname);

     void sendEmail(String toEmail, String subject, String body);
}

package am.shop.service;


import am.shop.model.User;
import am.shop.model.dto.request.UserRequestDto;
import am.shop.model.dto.response.UserResponseDto;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;


public interface UserService  {

    User getByUsername(String username) throws NotFoundExcaption;

    void  createUser(UserRequestDto dto) throws DuplicateException, BadRequestException, NotFoundExcaption;

    UserResponseDto getById(long id);

   List<UserResponseDto>  getByAll();
}

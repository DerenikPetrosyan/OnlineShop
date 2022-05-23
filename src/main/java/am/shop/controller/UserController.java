package am.shop.controller;

import am.shop.model.dto.request.UserRequestDto;
import am.shop.model.dto.response.UserResponseDto;
import am.shop.service.UserService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> crateUser(@RequestBody UserRequestDto dto) throws DuplicateException, BadRequestException, NotFoundExcaption {
        userService.createUser(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable long id){
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponseDto> getByAll(){
        return userService.getByAll();
    }
}


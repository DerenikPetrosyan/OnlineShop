package am.shop.controller;

import am.shop.model.dto.request.EditUserDto;
import am.shop.model.dto.request.ResetPasswordDto;
import am.shop.model.dto.request.UserRequestDto;
import am.shop.model.dto.response.UserResponseDto;
import am.shop.service.UserService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> crateUser(@Valid @RequestBody UserRequestDto dto) throws DuplicateException, BadRequestException, NotFoundExcaption {
        userService.createUser(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/for-all/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserInfo(id));
    }

    @GetMapping
    public List<UserResponseDto> getByAll() {
        return userService.getByAll();
    }

    //ete password@ moracel es es qo hamar nor code generacni unenalov menak email@
    @PatchMapping("/for-all/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestParam String email) throws NotFoundExcaption {

        userService.forgotPassword(email);

        return ResponseEntity.ok().build();
    }

    //sovorakan mtnum poxum es password@ unenalov mailid ekac cod@
    @PatchMapping("/for-all/reset-password")
    public ResponseEntity<Void> resetPassword(@Valid @RequestBody ResetPasswordDto dto) throws BadRequestException, NotFoundExcaption {

        userService.resetPassword(dto);

        return ResponseEntity.ok().build();

    }

    @PatchMapping("/for-all/edit-user")
    public ResponseEntity<Void> editUser(@Valid@RequestBody EditUserDto dto) throws NotFoundExcaption {
        userService.editUser(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("for-all/verify")
    public ResponseEntity<Void> verify(@RequestParam String email, @RequestParam String code) throws NotFoundExcaption, BadRequestException {
        userService.verify(email,code);
        return ResponseEntity.ok().build();
    }
}


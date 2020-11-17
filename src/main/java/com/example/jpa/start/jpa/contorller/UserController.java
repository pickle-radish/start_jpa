package com.example.jpa.start.jpa.contorller;

import com.example.jpa.start.jpa.dto.UserRequestDTO;
import com.example.jpa.start.jpa.dto.UserResponseDTO;
import com.example.jpa.start.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jpa/api/v2")
public class UserController {

    private final UserService service;

    @PostMapping("/user")
    public UserResponseDTO save(UserRequestDTO requestDto) {
        return service.save(requestDto);
    }

    @PutMapping("/user/{userId}")
    public UserResponseDTO update(@PathVariable Integer userId, UserRequestDTO requestDto) {
        return service.update(userId, requestDto);
    }

    @DeleteMapping("/user/{userId}")
    public String delete(@PathVariable Integer userId) {
        service.delete(userId);
        return "deleted complete";
    }


    @GetMapping("/user/{userId}")
    public UserResponseDTO select(@PathVariable Integer userId) {
        return service.select(userId);
    }


    @GetMapping("/user")
    public Page<UserResponseDTO> selectAll(@PageableDefault(sort = "userId", direction = Sort.Direction.DESC) Pageable pageable) {
        return service.selectAll(pageable);
    }



    @GetMapping("/user/class/{classNum}")
    public List<UserResponseDTO> selectClassNum(@PathVariable String classNum) {
        return service.selectClassNum(classNum);
    }
}

package com.muratguclu.springbootsummary.api;

import com.muratguclu.springbootsummary.business.abstracts.UserService;
import com.muratguclu.springbootsummary.dto.UserDto;

import com.muratguclu.springbootsummary.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        return ResponseEntity.ok(this.userService.createUser(userDto));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>>  getAllUsers(){

        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/getUserId")
    public ResponseEntity<UserDto>  getUserId(@RequestParam int id){
        return ResponseEntity.ok(this.userService.getUserId(id)) ;
    }
    @PutMapping("/updateUser")
    public ResponseEntity<UserDto>  updateUser(@RequestParam int id,@RequestBody UserDto userDto){
        return ResponseEntity.ok(this.userService.updateUser(id,userDto));
    }
    @DeleteMapping("/deleteUser")
    public Boolean deleteUser(@RequestParam int id){
        return this.userService.deleteUser(id);
    }
    @GetMapping("/pagination")
    public ResponseEntity<Page<User>>  pagination( @RequestParam int currentPage,@RequestParam int pageSize) {
        return ResponseEntity.ok(this.userService.pagination(currentPage,pageSize));
    }
    @GetMapping("/pagination/V1")
    public ResponseEntity<Page<User>>  pagination( Pageable pageable) {
        return ResponseEntity.ok(this.userService.pagination(pageable));
    }
    @GetMapping("/pagination/V2")
    public ResponseEntity<Slice<User>>  paginationWithSlice(Pageable pageable) {
        return ResponseEntity.ok(this.userService.paginationWithSlice(pageable));
    }

}

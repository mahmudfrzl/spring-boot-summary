package com.muratguclu.springbootsummary.business.abstracts;

import com.muratguclu.springbootsummary.dto.UserDto;
import com.muratguclu.springbootsummary.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;


import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    public UserDto getUserId(int id);

    public UserDto updateUser(int id, UserDto userDto);

    public Boolean deleteUser(int id);

    public Page<User> pagination(int currentPage, int pageSize);

    Page<User> pagination(Pageable pageable);
    Slice<User> paginationWithSlice(Pageable pageable);

}

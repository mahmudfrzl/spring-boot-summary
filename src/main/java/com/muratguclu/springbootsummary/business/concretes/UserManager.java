package com.muratguclu.springbootsummary.business.concretes;

import com.muratguclu.springbootsummary.advice.UserNotFound;
import com.muratguclu.springbootsummary.business.abstracts.UserService;
import com.muratguclu.springbootsummary.dataAccess.UserDao;
import com.muratguclu.springbootsummary.dto.UserDto;
import com.muratguclu.springbootsummary.entities.User;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        user.setCreatedAt(new Date());
        user.setCreatedBy("filankes");

        return modelMapper.map(this.userDao.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
    List<User> users = this.userDao.findAll();
    List<UserDto> resultDtos = users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());

        return resultDtos;
    }

    @Override
    public UserDto getUserId(int id) {
        Optional<User> user = this.userDao.findById(id);
        if(user.isPresent()){
            return modelMapper.map(user.get(),UserDto.class);
        }
        throw new UserNotFound("User doesn't exist");
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        Optional<User> user = this.userDao.findById(id);
        if(user.isPresent()){
            user.get().setFirstName(userDto.getFirstName());
            user.get().setLastName(userDto.getLastName());
            user.get().setUpdatedAt(new Date());
            user.get().setUpdatedBy("Admin");
            return modelMapper.map(this.userDao.save(user.get()),UserDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteUser(int id) {
        Optional<User> user = this.userDao.findById(id);
        if(user.isPresent()){
            this.userDao.deleteById(id);
            return true;
        }
        return null;
    }

    @Override
    public Page<User> pagination(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage,pageSize);

        return this.userDao.findAll(pageable);
    }

    @Override
    public Page<User> pagination(Pageable pageable) {

        return this.userDao.findAll(pageable);
    }

    @Override
    public Slice<User> paginationWithSlice(Pageable pageable) {
        return this.userDao.findAll(pageable);
    }
}

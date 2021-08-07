package com.muratguclu.springbootsummary.dataAccess;

import com.muratguclu.springbootsummary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}

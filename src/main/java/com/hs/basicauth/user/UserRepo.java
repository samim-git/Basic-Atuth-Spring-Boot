package com.hs.basicauth.user;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findUserById(@Param("id") int Id);
    ArrayList<User> findAll();
}

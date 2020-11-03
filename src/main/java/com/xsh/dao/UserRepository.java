package com.xsh.dao;

import com.xsh.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);
}

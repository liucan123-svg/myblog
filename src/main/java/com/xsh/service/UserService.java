package com.xsh.service;

import com.xsh.pojo.User;

public interface UserService {

    User checkUser(String username, String password);
}

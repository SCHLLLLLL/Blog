package com.day1.service;

import com.day1.po.User;

public interface UserService {

    User checkUser(String username, String password);
}

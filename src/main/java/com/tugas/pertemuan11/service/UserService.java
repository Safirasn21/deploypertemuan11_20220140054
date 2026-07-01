package com.tugas.pertemuan11.service;

import com.tugas.pertemuan11.model.User;
import java.util.Optional;

public interface UserService {
    User register(String username, String password);
    Optional<User> login(String username, String password);
    User findByUsername(String username);
}

package ru.itmentor.spring.boot_security.demo.service;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    void deleteUser(long id);
    User getByName(String name);
    User getById(long id);
    User editUser(User user);
    List<User> getAll();
    boolean hasUserId(Authentication authentication, int userId);


}





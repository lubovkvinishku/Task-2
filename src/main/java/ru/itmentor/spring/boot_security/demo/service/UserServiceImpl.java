package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.dao.UserRepository;
import ru.itmentor.spring.boot_security.demo.model.User;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addUser(User user) {
//        User savedUser = userRepository.saveAndFlush(user);
        User savedUser2 = userRepository.save(user);
        return savedUser2;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User getById(long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean hasUserId(Authentication authentication, int userId) {
        if (authentication==null){
            return false;
        }
        User currentUser=(User) authentication.getPrincipal();
        return currentUser!=null && currentUser.getId()==(userId);
    }
}

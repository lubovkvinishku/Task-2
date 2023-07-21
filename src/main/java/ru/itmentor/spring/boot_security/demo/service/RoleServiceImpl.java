package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.dao.RoleRepository;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getById(long id) {
        Optional<Role> optional = roleRepository.findById(id);
        return optional.orElse(null);
    }
}

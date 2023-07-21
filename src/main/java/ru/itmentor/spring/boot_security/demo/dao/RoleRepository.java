package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select b from Role b where b.id = :id")
    User findByName(@Param("id") String id);
}

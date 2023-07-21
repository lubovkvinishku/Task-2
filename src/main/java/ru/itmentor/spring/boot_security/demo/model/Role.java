package ru.itmentor.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    @Column
    private String role;
    @Column
    @ManyToMany(mappedBy = "roles")
    List<User> users;
    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }
      public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }
       public Role(String role) {
        this.role = role;
    }
    public Role() {
    }

    @Override
    public String getAuthority() {
        return role;
    }
}

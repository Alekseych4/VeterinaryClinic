package com.example.veterinary.domain.entity;

import com.example.veterinary.domain.dto.user.UserRole;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends EntityBase {
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    public User(UUID id, String email, String password, UserRole userRole) {
        super(id);
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(UUID id) {
        super(id);
    }

    public void setUser(User user){
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setUserRole(user.getUserRole());
    }
}

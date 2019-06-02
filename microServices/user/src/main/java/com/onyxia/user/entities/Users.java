package com.onyxia.user.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @NotEmpty
    public String username;

    @NotEmpty
    public String firstname;

    @NotEmpty
    public String lastname;

    @NotEmpty
    public String email;

    @NotEmpty
    public String password;

    public Date createdAt;


    public Date updatedAt;

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = new Date();
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

}

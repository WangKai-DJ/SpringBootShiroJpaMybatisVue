package com.qf.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 54110 on 2019-09-25.
 */
@Entity
@Table(name = "user_login")
@Data
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
}

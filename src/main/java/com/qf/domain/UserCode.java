package com.qf.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_code")
@Data
public class UserCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String username;
    private Integer status;
}

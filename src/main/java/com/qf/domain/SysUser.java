package com.qf.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_sys_user")
@Data
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private  int userId;//用户id
    @Column(name = "lobin_name")
    private String loginName;//登录名

    private String password;//
    private Integer state;
    @Column(name = "create_time")
    private Date createTime;
    private String realname;

    private String code;

}
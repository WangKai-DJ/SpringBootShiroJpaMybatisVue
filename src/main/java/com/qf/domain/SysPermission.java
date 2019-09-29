package com.qf.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_sys_permission")
@Data
public class SysPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perm_id")
    private int permId;
    @Column(name = "perm_name")
    private String permName;//权限名称
    @Column(name = "perm_url")
    private String permUrl;//权限操作地址（路径）
    @Column(name = "menu_name")
    private String menuName;//菜单名
    @Column(name = "menu_level")
    private String menuLevel;//菜单级别（11：一级；12：二级。。。）
    @Column(name = "menu_code")
    private String menuCode;//菜单编码（每级两位数字）
    @Column(name = "if_valid")
    private int ifValid;
    @Column(name = "parent_code")
    private String parentCode;
}

package com.qf.dao;

import com.qf.domain.UserCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserCodeMapper {
    UserCode findByName(@Param("username") String loginName);

    void update(UserCode usercode);

    void save(UserCode usercode);
}

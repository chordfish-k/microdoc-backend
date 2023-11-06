package com.microdoc.mapper;

import com.microdoc.pojo.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User getById(Long id);

    @Select("select * from user where phone = #{phone}")
    User getByPhone(String phone);

    @Insert("insert into user (name, phone, pwd, enable, is_admin)" +
            "values" +
            "(#{name}, #{phone}, #{pwd}, #{enable}, #{isAdmin})")
    void insert(User user);

    @Select("select * from user")
    List<User> selectAll();

    void update(User user);
}

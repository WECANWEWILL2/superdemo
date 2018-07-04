package com.wcww.superdemo.dao;

import com.wcww.superdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select(value = "SELECT * FROM User")
    List<User> getAllUsers();//查询全部用户

    @Select("Select * From User Where username=#{username}")
    User getUserByUsername(@Param("username") String username);

    @Select(value="Select * From User Where username=#{username} and password=#{password}")
    public User selectLogin(User user);//用户登录

    @Insert("Insert Into user(username,password,name,sex," +
            "birth,homeAddress,telephone,recommender,industryClub,specialCommittee) " +
            "values (#{username},#{username},#{password},#{name},#{sex},#{birth},#{homeAddress},#{telephone},#{recommender},#{industryClub},#{specialCommittee)")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int insert(User user);
}

package com.stockonline.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * 城市 DAO 接口类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Mapper // 标志为 Mybatis 的 Mapper
public interface UserDao {


    /**
     * 用户信息入库
     * @param userInfo
     */
    @Insert("INSERT INTO USER" +
            "(USERNAME, PASSWORD, EMAIL,USER_REG_DATE) VALUE" +
            "(#{username},#{password},#{email}," +
            "#{userRegDate})")
    void insertUserInfo(Map<String,String> userInfo);

    /**
     * 查询用户信息
     * @return
     */
    @Select("SELECT * FROM USER WHERE EMAIL=#{email} OR TEL=#{tel} OR USERNAME=#{username}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "tel", column = "TEL"),
    })
    Map<String,String> getUserInfo(String queryStr);
}

package com.stockonline.service.impl;

import com.stockonline.mapper.UserDao;
import com.stockonline.util.DateUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by lyh on 17-9-5.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void insertUserInfo(Map<String,String> info){
        info.put("userRegDate", DateUtils.getNowDateTime());//添加注册时间
        info.put("username","youke"+info.get("email").substring(0,info.get("email").indexOf("@")));
        userDao.insertUserInfo(info);
    }

    /**
     * 根据email查询用户信息并存入session
     * @param getUserInfo
     * @return
     */
    public Map<String,String> getUserInfo(String getUserInfo){
        return userDao.getUserInfo(getUserInfo);
    }


    public Boolean checkUserLogin(Map<String,String> info){
         return userDao.checkUserLogin(info);
    }
}

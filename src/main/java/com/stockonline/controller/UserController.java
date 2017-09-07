package com.stockonline.controller;

import com.stockonline.constant.BusinessConstant;
import com.stockonline.constant.SessionConstant;
import com.stockonline.domain.City;
import com.stockonline.service.impl.UserService;
import com.stockonline.util.MD5Util;
import com.stockonline.util.SendMailUtils;
import com.stockonline.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyh on 17-5-27.
 */
@RestController
public class UserController {

    @Autowired
    private SendMailUtils sendMailUtils;
    @Autowired
    private UserService userService;



    /**
     * 邮箱注册
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/stock/user/sendEmailCheckCode", method = RequestMethod.POST)
    public Map<String,Object> sendEmailCheckCode(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password",required = true) String password,
            HttpSession httpSession) {
        Map<String,Object> result = new HashMap<String, Object>();
        System.out.println("email= "+email+"password="+password);
        String md5Pssword = MD5Util.getSaltMd5(password);//使用加盐MD5加密
        Map<String,String> userInfo = new HashMap<>();
        userInfo.put("password",md5Pssword);
        userInfo.put("email",email);
        userInfo.put("username",email);
        //查询用户邮箱是否已存在
        Map<String, String> user = userService.getUserInfo(email);
        if(!StringUtils.isEmpty(user)){
            result.put(BusinessConstant.AJAX_STATUS,BusinessConstant.AJAX_STATUS_ERROR);
            result.put(BusinessConstant.AJAX_RESULT_MSG,"用户信息已存在，请找回密码或更改用户注册邮箱");
            return result;
        }
        userService.insertUserInfo(userInfo);
        sendMailUtils.registerEmail(email);
        //同步用户信息到session
        user = userService.getUserInfo(email);
        httpSession.setAttribute(SessionConstant.SESSION_USER_KEY,user);
        result.put(BusinessConstant.USER_NAME,user.get("username"));
        result.put(BusinessConstant.AJAX_STATUS,BusinessConstant.AJAX_STATUS_SUCCESS);
        return result;
    }
    /**
     *
     * @param activeCode
     * @return
     */
    @RequestMapping(value = "/stock/user/emailActive", method = RequestMethod.GET)
    public String emailActive(@RequestParam(value = "activeCode", required = true) String activeCode) {
        //TODO 从缓存中取出加密的激活码进行比较
        if("123".equals(activeCode)){
            return "<H1>ACTIVE ERROR !</H1>";
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(BusinessConstant.AJAX_STATUS,BusinessConstant.AJAX_STATUS_SUCCESS);
        return "<H1>ACTIVE SUCCESS !</H1>";
    }


    @RequestMapping(value = "/stock/user/getUserInfo", method = RequestMethod.GET)
    public Map<String,Object> getUserInfo(HttpSession httpSession,
    @RequestParam(value = "queryStr", required = true) String queryStr){
        Map<String, String> userInfo = (Map<String, String>)httpSession.getAttribute(SessionConstant.SESSION_USER_KEY);
        Map<String,Object> result = new HashMap<>();
        result.put("userInfo",userInfo);
        result.put(BusinessConstant.AJAX_STATUS,BusinessConstant.AJAX_STATUS_SUCCESS);
        return result;
    }

    @RequestMapping(value = "/stock/user/useLogin", method = RequestMethod.GET)
    public Map<String,Object> useLogin (@RequestParam(value = "email", required = true) String email,
    @RequestParam(value = "password",required = true) String password,
    HttpSession httpSession){
        Map<String,Object> result = new HashMap<String, Object>();
        System.out.println("email= "+email+"password="+password);
        String md5Pssword = MD5Util.getSaltMd5(password);//使用加盐MD5加密
        Map<String,String> userInfo = new HashMap<>();
        userInfo.put("password",md5Pssword);
        userInfo.put("email",email);
        userInfo.put("username",email);
        //查询用户邮箱是否已存在
        Map<String, String> user = userService.getUserInfo(email);
        if(StringUtils.isEmpty(user)){
            result.put(BusinessConstant.AJAX_STATUS,BusinessConstant.AJAX_STATUS_ERROR);
            result.put(BusinessConstant.AJAX_RESULT_MSG,"用户邮箱不存在，请注册");
            return result;
        }
        //登录校验
        boolean b = userService.checkUserLogin(userInfo);
        return null;

    }


}

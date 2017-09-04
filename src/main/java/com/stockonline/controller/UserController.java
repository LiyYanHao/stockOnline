package com.stockonline.controller;

import com.stockonline.constant.BusinessConstant;
import com.stockonline.domain.City;
import com.stockonline.util.MD5Util;
import com.stockonline.util.SendMailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyh on 17-5-27.
 */
@RestController
public class UserController {

    @Autowired
    private SendMailUtils sendMailUtils;

    /**
     * 邮箱注册
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/stock/user/sendEmailCheckCode", method = RequestMethod.POST)
    public Map<String,Object> sendEmailCheckCode(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password",required = true) String password) {
        Map<String,Object> result = new HashMap<String, Object>();
        System.out.println("email= "+email+"password="+password);
        //TODO 把密码和用户名存入数据库
        String md5Pssword = MD5Util.getSaltMd5(password);//使用加盐MD5加密

        sendMailUtils.registerEmail(email);
        result.put(BusinessConstant.AJAX_STATUS,BusinessConstant.AJAX_STATUS_SUCCESS);
        return result;
    }

    /**
     *
     * @param activeCode
     * @return
     */
    @RequestMapping(value = "/stock/user/emailActive", method = RequestMethod.GET)
    public String emailActive(
            @RequestParam(value = "activeCode", required = true) String activeCode) {
        //TODO 从缓存中取出加密的激活码进行比较
        if("123".equals(activeCode)){
            return "<H1>ACTIVE ERROR !</H1>";
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(BusinessConstant.AJAX_STATUS,BusinessConstant.AJAX_STATUS_SUCCESS);
        return "<H1>ACTIVE SUCCESS !</H1>";
    }


}

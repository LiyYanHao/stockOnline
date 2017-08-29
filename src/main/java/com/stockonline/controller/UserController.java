package com.stockonline.controller;

import com.stockonline.domain.City;
import com.stockonline.util.SendMailUtils;
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

    /**
     * 邮箱注册
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/user/Emailregister", method = RequestMethod.POST)
    public Map<String,Object> sendEmailCheckCode(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password",required = true) String password) {
        Map<String,Object> result = new HashMap<String, Object>();
        System.out.println("email= "+email+"password="+password);
        SendMailUtils.registerEmail(email);
        result.put("status","1");
        return result;
    }

    @RequestMapping(value = "/user/emailActive", method = RequestMethod.GET)
    public City emailActive(
            @RequestParam(value = "activeCode", required = true) String activeCode) {
        System.out.println(activeCode);

        return null;
    }


}

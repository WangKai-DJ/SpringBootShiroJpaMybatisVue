package com.qf.controller;

import com.qf.service.UserLoginService;
import com.qf.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLoginController {
@Autowired
    private UserLoginService userLoginService;
@Autowired
private EmailUtils emailUtils;
@RequestMapping("/sendMail")
    @ResponseBody
    public String sendMail(@RequestParam("username") String username){
    String s=emailUtils.sendMail(username);
    if(!s.isEmpty()){
        return "success";
    }else {
        return "fail";
    }

}

}

package com.qf.utils;

import com.qf.dao.UserCodeMapper;
import com.qf.domain.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmailUtils {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserCodeMapper userCodeMapper;

    public String sendMail(String sendTo) {//传递的参数???
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("注册验证码");
        String code = randomCode();
        //simpleMailMessage.setText(code);
        // simpleMailMessage.setFrom(from);
        // simpleMailMessage.setTo(sendTo);
        try{
            // javamailSender.send(simpleMailMessage);
            UserCode usercode = new UserCode();
            usercode.setCode(code);
            usercode.setUsername(sendTo);
            //设置当前验证码得状态
            usercode.setStatus(1);

            //通过姓名查询验证码，如果已存在，更新，不存在增加
            UserCode byName = userCodeMapper.findByName(sendTo);
            if (byName!=null){
                userCodeMapper.update(usercode);
            }
            userCodeMapper.save(usercode);
            return code;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }
    public static String randomCode(){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<6;i++) {
            int i1 = random.nextInt(9);
            stringBuffer.append(i1);
        }
        return stringBuffer.toString();
    }



}

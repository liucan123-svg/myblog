package com.xsh.customer;

import com.aliyuncs.exceptions.ClientException;
import com.xsh.listener.SmsListener;
import com.xsh.util.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;



@Component
public class SmsCustomer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private SmsListener smsListener;
    /*将数据存入redis时key值的前缀，用于区分来源*/
    private static final String KEY_PREFIX="sms:";
    /**
     * 向指定手机号发送验证码
     * @param phone
     */
    public void sendVerifyCode(String phone) {
        if(StringUtils.isBlank(phone)){
            return;
        }
        //生成验证码,6位随机数
        String code= NumberUtils.generateCode(6);
        Map<String,String> msg=new HashMap<>();
        msg.put("phone",phone);
        msg.put("code",code);
//        msg.put("code","1234567");
        //发送消息到rabbitMQ
        //this.amqpTemplate.convertAndSend("sms.exchange","verifycode.sms",msg);

        try {
            smsListener.sendSms(msg);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        //把验证码保存到redis中并设置过期时间为5分钟
        //this.redisTemplate.opsForValue().set(KEY_PREFIX+phone,code,5, TimeUnit.MINUTES);
    }
}

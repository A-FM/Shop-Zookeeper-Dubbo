package pers.ycy.myshop.service.user.consumer.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import pers.ycy.myshop.service.user.api.UserConsumerService;

@Service(version = "${services.versions.user.v1}")
public class UserConsumerServiceImpl implements UserConsumerService{

    @Override
    public void info() {
        System.out.println("asdasdasdasd");
    }
}
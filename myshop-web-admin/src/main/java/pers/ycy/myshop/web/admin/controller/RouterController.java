package pers.ycy.myshop.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.ycy.myshop.service.content.api.ContentConsumerService;
import pers.ycy.myshop.service.user.api.UserConsumerService;

@Controller
@RequestMapping(value = "router")
public class RouterController {

    @Reference(version = "${services.versions.user.v1}")
    private UserConsumerService userConsumerService;

    @Reference(version = "${services.versions.content.v1}")
    private ContentConsumerService contentConsumerService;

    @Value(value = "${services.ports.user}")
    private String userPort;

    @Value(value = "${services.ports.content}")
    private String contentPort;

    @RequestMapping(value = "user",method = RequestMethod.GET)
    public String user(String path) {
        userConsumerService.info();
        return getRequest(path,userPort);
    }
    @RequestMapping(value = "content",method = RequestMethod.GET)
    public String content(String path) {
        contentConsumerService.info();
        return getRequest(path,contentPort);
    }
    private String getRequest(String path,String port){
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
        if (isConsumerSide) {
            String remoteHost = RpcContext.getContext().getRemoteHost();
            StringBuilder stringBuilder = new StringBuilder("redirect:http://");
            stringBuilder.append(remoteHost).append(":").append(port).append(path);
            return String.valueOf(stringBuilder);
        }
        return null;
    }

}
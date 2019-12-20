package pers.ycy.myshop.service.content.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableHystrix
@EnableHystrixDashboard
/* 配置Java配置  文件路径.   不然的话,Java配置文件无法生效. */
@SpringBootApplication(scanBasePackages = "pers.ycy.myshop")
@EnableTransactionManagement
@MapperScan(basePackages = "pers.ycy.myshop.commons.mapper")
public class MyShopServiceContentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceContentProviderApplication.class, args);
        Main.main(args);
    }
}

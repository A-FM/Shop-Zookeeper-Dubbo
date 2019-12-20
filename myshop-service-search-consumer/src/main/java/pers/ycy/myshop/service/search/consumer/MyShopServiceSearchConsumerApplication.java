package pers.ycy.myshop.service.search.consumer;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableHystrixDashboard
/* 这里是面向前端的, 不需要和数据库勾搭, 但是我们的依赖里面有 PageHelper , PageHelper 依赖的有
 * mybatis , SpringBoot 去application.yml 里面没有找到数据源配置 , 然后 就开始报错.
 * 但是我们不需要和数据库打交道, 所以这里排除一下 数据源的自动配置.
 * */
@SpringBootApplication(scanBasePackages = "pers.ycy.myshop",exclude = DataSourceAutoConfiguration.class)
public class MyShopServiceSearchConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceSearchConsumerApplication.class);
        Main.main(args);
    }
}
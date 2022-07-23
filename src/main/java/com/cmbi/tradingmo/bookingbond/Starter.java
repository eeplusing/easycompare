package com.cmbi.tradingmo.bookingbond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 启用Kafka @EnableKafka
 * 启用Feign @EnableFeign
 * 允许使用自定义配置对象 @EnableConfigurationProperties
 * 启用AOP @EnableAspectJAutoProxy
 * 开启spring事务 @EnableTransactionManagement
 */
//@EnableKafka
@EnableConfigurationProperties
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@SpringBootApplication(
        scanBasePackages = "com.cmbi", exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class}
)
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

}

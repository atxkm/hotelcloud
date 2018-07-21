package cn.zhsit;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Darren
 * @email 61947666@qq.com
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
@EnableCaching
@ConfigurationProperties(prefix="spring")
@MapperScan({"cn.zhsit.authority.daos","cn.zhsit.hotel.daos"})
public class ServerApplication {
    private  Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}

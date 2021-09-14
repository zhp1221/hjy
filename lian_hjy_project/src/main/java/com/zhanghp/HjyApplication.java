package com.zhanghp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan
public class HjyApplication {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
        SpringApplication.run(HjyApplication.class,args);
    }
}

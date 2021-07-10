package com.hyd.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * @author ayiyaha
 */
@Configuration
@MapperScan("com.hyd.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}

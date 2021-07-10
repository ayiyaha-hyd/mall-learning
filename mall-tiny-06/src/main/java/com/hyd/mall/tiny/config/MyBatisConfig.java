package com.hyd.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * @author ayiyaha
 */

/**
 * Mybatis配置类
 * 要注意dao层和mapper层都要包扫描
 */
@Configuration
@MapperScan({"com.hyd.mall.tiny.mbg.mapper","com.hyd.mall.tiny.dao"})
public class MyBatisConfig {
}

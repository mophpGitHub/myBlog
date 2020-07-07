package com.whz.myblog.config;

import com.whz.myblog.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 卫宏哲
 * @date 2020/3/8 14:08
 * 用于将一些实体类放入Spring容器
 */
@Configuration
public class BeanConfig {
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}

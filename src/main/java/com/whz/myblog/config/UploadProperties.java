package com.whz.myblog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 卫宏哲
 * @date 2020/3/9 17:57
 */
@ConfigurationProperties(prefix = "upload")
@Data
@Component
public class UploadProperties {

    private String baseUrl;

    private List<String> allowTypes;
}
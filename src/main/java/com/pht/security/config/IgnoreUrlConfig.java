package com.pht.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlConfig {
    private List<String> urls = new ArrayList<>();//白名单
    private List<String> defSourceUrl = new ArrayList<>();//默认数据源操作
    public List<String> getAllIgnoreUrls(){

        List<String> objects = new ArrayList<>();
        if(urls!=null){
            objects.addAll(urls);
        }
        if(defSourceUrl!=null){
            objects.addAll(defSourceUrl);
        }
        return objects;
    }
}

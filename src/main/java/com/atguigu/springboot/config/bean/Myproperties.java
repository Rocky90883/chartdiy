package com.atguigu.springboot.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 该类为配置类可以resource/config目录下的配置文件，当然也可以另外指定路径
 */
@Component
@ConfigurationProperties(prefix="web")
@PropertySource(value={"classpath:config/my-web.properties"})
public class Myproperties {

    private String name;
    private String version;
    private String author;

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public String getVersion() {
        return version;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVersion(String version) {
        this.version = version;
    }

}

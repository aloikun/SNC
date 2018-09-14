package com.wangdao.snc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class SncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SncApplication.class, args);
    }

    // 要设置临时文件路径，文件就不能写入了
    @Bean
    MultipartConfigElement multipartConfigFactory(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        factory.setLocation(path.getPath());
        return factory.createMultipartConfig();
    }
}

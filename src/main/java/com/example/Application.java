package com.example;

import com.example.demo1.springextension.HttpControllerScannerRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Author zhangzhen
 * @create 2022/12/31 10:30
 */
@Import(HttpControllerScannerRegistrar.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

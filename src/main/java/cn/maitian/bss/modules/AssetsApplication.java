package cn.maitian.bss.modules;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liguo
 * @date 2022-04-01 15:33
 */
@EnableKnife4j
@SpringBootApplication
public class AssetsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssetsApplication.class, args);
    }
}

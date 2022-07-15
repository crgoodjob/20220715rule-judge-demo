package cn.maitian.bss.modules.office.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 办公用品系统类配置信息
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mt.bss.office")
public class OfficeConfig {

    /**
     * 事业部的Ids
     */
    private List<String> deptBusinessIds;

}

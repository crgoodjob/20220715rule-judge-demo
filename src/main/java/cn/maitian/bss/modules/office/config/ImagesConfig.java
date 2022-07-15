package cn.maitian.bss.modules.office.config;

import cn.maitian.bss.modules.system.utils.DateUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

/**
 * 图片上传相关配置
 * @author ChangRui
 * @version 1.0
 * @date 2022-04-14 9:28
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mt.bss.images")
public class ImagesConfig {
    /**
     * 内网地址
     */
    private String serverAddress;

    /**
     * 外网地址
     */
    private String serverAddressOut;

    /**
     * 图片服务器上传url
     */
    private String serverUplodUrl;

    /**
     * 服务器存储path：办公用品
     */
    private String serverOfficePath;

    /**
     * 服务器存储path：资产
     */
    private String serverAssetsPath;


    /**
     * 内网上传地址
     */
    public String requestUrl() {
        return getServerAddress() + getServerUplodUrl();
    }

    /**
     * 外网上传地址
     */
    public String requestUrlOut() {
        return getServerAddressOut() + getServerUplodUrl();
    }

}

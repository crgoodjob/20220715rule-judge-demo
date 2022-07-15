package cn.maitian.bss.modules.config;

import cn.maitian.bss.modules.change.utils.DroolsUtils;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Drools规则引擎配置
 * 读取默认配置下xml和drl文件，可使用自定义配置的kSession
 * @author ChangRui
 * @version 1.0
 * @date 2021-10-13 16:59
 */
@Slf4j
@Configuration
public class KieConfig {
    private final KieServices kieServices = KieServices.Factory.get();

    @Bean
    @ConditionalOnMissingBean(KieFileSystem.class)
    public KieContainer kieContainer() throws IOException {
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        DroolsUtils.setKieContainer(kieContainer);
        return kieContainer;
    }

    @Bean
    @ConditionalOnMissingBean(KieBase.class)
    public KieBase kieBase() throws IOException {
        return kieContainer().getKieBase();
    }
}

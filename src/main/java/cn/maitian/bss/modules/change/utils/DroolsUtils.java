package cn.maitian.bss.modules.change.utils;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2021-10-14 9:41
 */
public class DroolsUtils {
    private static KieContainer kieContainer;

    private static KieSession kieSession;

    public static KieContainer getKieContainer() {
        return kieContainer;
    }

    public static void setKieContainer(KieContainer kieContainer) {
        DroolsUtils.kieContainer = kieContainer;
        kieSession = kieContainer.newKieSession();
    }

    public static KieSession getKieSession() {
        return kieSession;
    }

    public static void setKieSession(KieSession kieSession) {
        DroolsUtils.kieSession = kieSession;
    }
}

package cn.maitian.bss.modules.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class GeneratorCodeConfig {

    public static void main(String[] args) {

        DataSourceConfig dsc = new DataSourceConfig.Builder("jdbc:oracle:thin:@172.16.12.133:1521/BSSBAKPDB17_20220622", "BSS_HTS_BEIJING", "BSS_HTS_BEIJING").build();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dsc);
 
        // String[] tableNames = new String[]{"ZC_ASSET_CLASS", "ZC_OFFICE_APPLY", "ZC_OFFICE_APPLY_INFO", "ZC_DICT_INFO", "ZC_OFFICE_SUP_INFO", "ZC_OFFICE_SUP_SET", "ZC_RECEIVE_ADDRESS"};
        String[] tableNames = new String[]{"RULE_APPOINT_BRANCH",
                "RULE_APPOINT_ORG",
                "RULE_CHOOSE_APPOINT_BRANCH",
                "RULE_CHOOSE_APPOINT_ORG",
                "RULE_CHOOSE_WHITE_LIST",
                "RULE_CONFIG",
                "RULE_JUDGE_CHOOSE",
                "RULE_JUDGE_MAIN",
                "RULE_JUDGE_TAKE_AWAY",
                "RULE_LOCK_RELATION",
                "RULE_LOCK_SET",
                "RULE_OCCUPY",
                "RULE_SUPERIOR",
                "RULE_SUPERIOR_ORG",
                "RULE_TAKE_AWAY_OCCUPY",
                "RULE_WHITE_LIST"};
        String moduleName = "";
        String projectPath = "D:\\xiaomai\\workspace-idea-svn\\asset\\master\\rule-judge-demo\\";
 
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig
                .Builder()
                .outputDir(projectPath + "/" + moduleName + "/src/main/java")
                .author("liguo")
                .openDir(false)
                .build();
 
        // 包配置
        PackageConfig packageConfig = new PackageConfig
                .Builder()
                .entity("model")
                .xml("dao")
                .mapper("dao")
                .controller("controller")
                .parent("cn.maitian.bss.modules.change")
                .moduleName(moduleName)
                .build();
 
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig
                .Builder()
                //.service(null,null)
                //.mapperXml(null)
                .controller(null)
                .build();
 
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig
                .Builder()
                //.addInclude("FLW_FORM")
                .addInclude(tableNames)
                .entityBuilder().enableLombok().naming(NamingStrategy.underline_to_camel)
                .serviceBuilder().formatServiceFileName("%sIService")
                .build();
 
        mpg.global(globalConfig);
        mpg.packageInfo(packageConfig);
        mpg.template(templateConfig);
        mpg.strategy(strategyConfig);
        mpg.execute(new FreemarkerTemplateEngine());
    }
}
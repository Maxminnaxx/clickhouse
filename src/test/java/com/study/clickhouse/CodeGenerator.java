package com.study.clickhouse;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.querys.ClickHouseQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {

    private static final String REPLACE_LOCAL_PATH = "/target/test-classes/";
    private static final String JAVA_PATH = "/src/main/java";
    public static void main(String[] args) {

        // 获取项目路径
        String projectPath = ClassLoader.getSystemResource("").getPath().replace(REPLACE_LOCAL_PATH, "");
        // 全局配置
        GlobalConfig gc = GeneratorBuilder.globalConfigBuilder()
                .fileOverride().openDir(false)
                .outputDir(projectPath + JAVA_PATH)
                .author("generator")
                .enableSwagger()
                .commentDate("yyyy-MM-dd").build();


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig.Builder("jdbc:clickhouse://192.168.3.137:8123", null, "cOhglnbf")
                .dbQuery(new ClickHouseQuery()).schema("study").build();


        // 包配置
        PackageConfig pc = GeneratorBuilder.packageConfigBuilder().parent("com.study.clickhouse").build();

        // 策略配置
        StrategyConfig strategy = GeneratorBuilder.strategyConfigBuilder()
                .addInclude("test_table")
                .addTablePrefix(pc.getModuleName() + "_")
                .controllerBuilder().enableHyphenStyle()
                .entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .versionColumnName("version").logicDeleteColumnName("isDelete")
                .enableLombok()
                .build();

        TemplateConfig templateConfig = GeneratorBuilder.templateConfigBuilder().build();

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dsc).global(gc).strategy(strategy).template(templateConfig).packageInfo(pc);


        mpg.execute(new FreemarkerTemplateEngine());
//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//        // String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(projectPath);
//                sb.append("/src/main/resources/mapper/");
//                if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(pc.getModuleName())) {
//                    sb.append(pc.getModuleName());
//                    sb.append("/");
//                }
//
//                sb.append(tableInfo.getEntityName());
//                sb.append("Mapper");
//                sb.append(StringPool.DOT_XML);
//
//                return sb.toString();
//            }
//        });
//
//        cfg.setFileOutConfigList(focList);

    }
}

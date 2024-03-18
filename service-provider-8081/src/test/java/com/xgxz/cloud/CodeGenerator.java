package com.xgxz.cloud;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.junit.jupiter.api.Test;

import java.sql.Types;
import java.util.Collections;

//@SpringBootTest
class CodeGenerator {

    @Test
    public void code() {
        FastAutoGenerator
                .create("jdbc:mysql://localhost:3306/cloud2024?serverTimezone=GMT%2B8&characterEncoding=utf-8",
                        "root",
                        "wzgxhcxy$%95")
                .globalConfig(builder -> {
                    builder.author("习惯向左") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/src/main/java")// 指定输出目录
                            .disableOpenDir()
                    ;
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.xgxz.cloud") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/java/com/xgxz/cloud/mapper/xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_pay") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀

                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .enableRemoveIsPrefix()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                            .logicDeleteColumnName("is_deleted")
                            .idType(IdType.ASSIGN_ID)

                            .controllerBuilder()
                            .enableRestStyle()

                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                    ;
                })
                .injectionConfig(builder -> {
                    builder.customFile(Collections.singletonMap("test", "/templates/entity.java.vm"))
                            .build();
                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}

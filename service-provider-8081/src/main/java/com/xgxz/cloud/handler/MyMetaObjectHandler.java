package com.xgxz.cloud.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("新增自动填充。。。");

        // 新增自动填充
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        this.strictInsertFill(metaObject, "deleted", Boolean.class, false);

        this.strictInsertFill(metaObject, "disabled", Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        log.info("修改自动填充。。。");
        // 修改自动填充
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}

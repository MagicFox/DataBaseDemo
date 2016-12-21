package com.fox.database;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

/**
 * Created by MagicFox on 2016/11/24.
 */
public class ExampleDaoGenerator {
    public static void main(String[] args) throws Exception {
        //entity的路径
        Schema schema = new Schema(1, "com.fox.database.db.entity");
        //dao的路径
        schema.setDefaultJavaPackageDao("com.fox.database.db.dao");

        addBusinessReport(schema);
        //生成代码的路径
        new DaoGenerator().generateAll(schema,"D:\\hyx_not_delete\\6_demo\\sqlite\\liteOrm\\GreenDaoGenerator\\src\\main\\java");
    }


    //出差报告
    public static void addBusinessReport(Schema schema){
        Entity entity = schema.addEntity("BusinessReport");
        //自动生成
        entity.addIdProperty().primaryKey().autoincrement();
        //员工
        entity.addStringProperty("employee");
        //客户
        entity.addStringProperty("customer");
        //有效期自
        entity.addDateProperty("startExpire");
        //有效期至
        entity.addDateProperty("endExpire");
        //城市
        entity.addStringProperty("city");
        entity.addDateProperty("createTime");
        entity.addStringProperty("taskId");
    }


}

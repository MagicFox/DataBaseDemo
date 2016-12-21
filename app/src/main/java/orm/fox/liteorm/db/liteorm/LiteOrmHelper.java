package orm.fox.liteorm.db.liteorm;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;

import orm.fox.liteorm.Constant;
import orm.fox.liteorm.MyApplication;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class LiteOrmHelper {
    private LiteOrm liteOrm;
    private volatile static LiteOrmHelper instance;
    private LiteOrmHelper(){
        DataBaseConfig config = new DataBaseConfig(MyApplication.getInstance(), Constant.db.LITE_ORM_DB_NAME);
        config.debugged = Constant.db.isDebug;
        config.dbVersion = Constant.db.DB_VERSION;
        config.onUpdateListener = null;
        liteOrm = LiteOrm.newSingleInstance(config);
    }

    public  LiteOrm getLiteOrm(){
        return liteOrm;
    }

    public static LiteOrmHelper getInstance(){
        if(instance == null){
            synchronized (LiteOrmHelper.class){
                if(instance == null){
                    instance = new LiteOrmHelper();
                }
            }
        }
        return instance;
    }

}

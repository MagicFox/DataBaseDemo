package orm.fox.liteorm.db.greendao;

import android.database.sqlite.SQLiteDatabase;

import orm.fox.liteorm.Constant;
import orm.fox.liteorm.MyApplication;
import orm.fox.liteorm.db.greendao.dao.DaoMaster;
import orm.fox.liteorm.db.greendao.dao.DaoSession;


/**
 * Created by MagicFox on 2016/12/20.
 * operate to single database
 */

public class GreenDaoHelper {

    private DaoSession daoSession;
    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;

    GreenDaoHelper(){
        helper = new DaoMaster.DevOpenHelper(MyApplication.getInstance(), Constant.db.GREEN_DAO_DB_NAME, null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private static class DBUtilsHolder{
        static GreenDaoHelper INSTANCE = new GreenDaoHelper();
    }

    public static GreenDaoHelper getInstance(){
        return DBUtilsHolder.INSTANCE;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb(){
        return db;
    }
}

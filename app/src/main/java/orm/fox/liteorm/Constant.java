package orm.fox.liteorm;

/**
 * Created by MagicFox on 2016/12/20.
 */

public interface Constant {
    boolean isDebug = true;

    interface db{
        String LITE_ORM_DB_NAME = "fox_demo.db";
        String GREEN_DAO_DB_NAME = "note";
        boolean isDebug = Constant.isDebug;
        int DB_VERSION = 1;
    }
}

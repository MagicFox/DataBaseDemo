package orm.fox.liteorm.db;

import java.util.List;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class DbHelper {
    DbProxy proxy;
    public DbHelper(DbProxy proxy){
        this.proxy = proxy;
    }

    public <T> long insert(T t){
        return proxy.insert(t);
    }

    public <T> void update(T t){
        proxy.update(t);
    }

    public <T> List<T> query(Class<T> entity){
        return proxy.query(entity);
    }

    public <T> void delete(T t){
         proxy.delete(t);
    }
}

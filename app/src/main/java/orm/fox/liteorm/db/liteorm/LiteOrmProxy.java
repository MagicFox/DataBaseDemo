package orm.fox.liteorm.db.liteorm;

import java.util.List;

import orm.fox.liteorm.db.DbProxy;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class LiteOrmProxy implements DbProxy {

    @Override
    public <T> long insert(T entity) {
        return LiteOrmHelper.getInstance().getLiteOrm().insert(entity);
    }

    @Override
    public <T> void update(T entity) {
        LiteOrmHelper.getInstance().getLiteOrm().update(entity);
    }

    @Override
    public <T> List<T> query(Class<T> entity) {
        return LiteOrmHelper.getInstance().getLiteOrm().query(entity);
    }

    @Override
    public <T> void delete(T entity) {
        LiteOrmHelper.getInstance().getLiteOrm().delete(entity);
    }

}

package orm.fox.liteorm.db.greendao;

import java.util.List;

import orm.fox.liteorm.db.DbProxy;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class GreenDaoProxy implements DbProxy{
    @Override
    public <T> long insert(T entity) {
        return GreenDaoHelper.getInstance().getDaoSession().insert(entity);
    }

    @Override
    public <T> void update(T entity) {
        GreenDaoHelper.getInstance().getDaoSession().update(entity);
    }

    @Override
    public <T> List<T> query(Class<T> entity) {
        return GreenDaoHelper.getInstance().getDaoSession().queryBuilder(entity).build().list();
    }

    @Override
    public <T> void delete(T entity) {
        GreenDaoHelper.getInstance().getDaoSession().delete(entity);
    }
}

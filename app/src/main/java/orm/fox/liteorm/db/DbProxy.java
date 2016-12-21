package orm.fox.liteorm.db;

        import java.util.List;

/**
 * Created by MagicFox on 2016/12/20.
 */

public interface DbProxy {
    <T> long insert(T entity);

    <T> void update(T entity);

    <T> List<T> query(Class<T> entity);

    <T> void delete(T entity);
}

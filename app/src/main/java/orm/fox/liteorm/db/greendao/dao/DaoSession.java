package orm.fox.liteorm.db.greendao.dao;


import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

import orm.fox.liteorm.db.greendao.entity.BusinessReport;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig businessReportDaoConfig;

    private final BusinessReportDao businessReportDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);


        businessReportDaoConfig = daoConfigMap.get(BusinessReportDao.class).clone();
        businessReportDaoConfig.initIdentityScope(type);

        businessReportDao = new BusinessReportDao(businessReportDaoConfig, this);

        registerDao(BusinessReport.class, businessReportDao);
    }
    
    public void clear() {
        businessReportDaoConfig.clearIdentityScope();
    }

    public BusinessReportDao getBusinessReportDao() {
        return businessReportDao;
    }

}

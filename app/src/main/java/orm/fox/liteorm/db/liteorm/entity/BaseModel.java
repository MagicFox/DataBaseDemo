package orm.fox.liteorm.db.liteorm.entity;

import com.litesuits.orm.db.annotation.Ignore;

import java.io.Serializable;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class BaseModel implements Serializable {
    @Ignore
    private String ignore = " 我是ignore";

//    @Check("all is not null")
//    private String all = "我是共有的属性";

}

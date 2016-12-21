package orm.fox.liteorm.db.liteorm.entity;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by MagicFox on 2016/12/20.
 */
@Table("User")
public class User extends BaseModel{

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    @Column("id")
    public long id;

    @Column("_name")
    public String name;

    @Column("rule")
    public String rule;

    public String otherInfo;

}

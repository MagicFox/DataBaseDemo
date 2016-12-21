package orm.fox.liteorm;

import android.app.Application;
import android.content.Context;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class MyApplication extends Application {

    static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance(){
        return instance;
    }
}

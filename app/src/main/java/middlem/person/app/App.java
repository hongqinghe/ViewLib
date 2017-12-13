package middlem.person.app;

import android.app.Application;
import android.util.Log;

import middlem.person.utilsmodule.LogUtils;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/12/1 14:12
 ***********************************************/

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.setLogEnable(true);
    }
}

package middlem.person.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.WindowManager;

import middlem.person.utilsmodule.comutils.LogUtils;
import person.middlem.viewmodule.system.AppLifecycleManager;


/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/12/1 14:12
 ***********************************************/

public class App extends Application {
    private static WindowManager.LayoutParams wmParams=new WindowManager.LayoutParams();
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.setLogEnable(true);
        registerActivityLifecycleCallbacks(new AppLifecycleManager());
    }
    public  static Application getInstance(){
       return new App();
    }
    public  static WindowManager.LayoutParams getMywmParams(){
        return wmParams;
    }
}

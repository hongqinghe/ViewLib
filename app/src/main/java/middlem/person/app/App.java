package middlem.person.app;

import android.app.Application;
import android.util.Log;
import android.view.WindowManager;

import middlem.person.utilsmodule.LogUtils;

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
    }
    public  static Application getInstance(){
       return new App();
    }
    public  static WindowManager.LayoutParams getMywmParams(){
        return wmParams;
    }
}

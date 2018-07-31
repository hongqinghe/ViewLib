package person.middlem.viewmodule.system;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/***********************************************
 * <P> desc:    activity 生命周期管理类
 *              ActivityLifecycleCallbacks接口对应的activity中的生命周期 只需要在每个生命周期中加入逻辑即可
 * <P> Author: gongTong
 * <P> Date: 2018/4/19 19:51
 ***********************************************/

public class AppLifecycleManager implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        TDFActivityStackManager.getInstance().addStackActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {


    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        TDFActivityStackManager.getInstance().finishActivityExcept(activity);
    }
}

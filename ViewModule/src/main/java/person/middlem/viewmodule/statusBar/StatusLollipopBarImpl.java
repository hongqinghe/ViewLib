package person.middlem.viewmodule.statusBar;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/***********************************************
 * <P> desc:   android 5.0 以上版本的适配
 * <P> Author: gongtong
 * <P> Date: 2017/12/12 13:43
 ***********************************************/

class StatusLollipopBarImpl implements IStatusBar {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setWindowStatusBar(Activity activity, int color) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        activity.getWindow().setStatusBarColor(color);
    }
}

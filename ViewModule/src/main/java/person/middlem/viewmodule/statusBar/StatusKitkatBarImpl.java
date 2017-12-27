package person.middlem.viewmodule.statusBar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import person.middlem.viewmodule.R;

/***********************************************
 * <P> desc:    实现4.4版本的适配
 * <P> Author: gongton8g
 * <P> Date: 2017/12/12 10:54
 ***********************************************/

class StatusKitkatBarImpl implements IStatusBar {
    private static final String STATUS_BAR_TAG="statusBar";
    private static final int FAKE_STATUS_BAR_VIEW_ID = R.id.status_bar_fake_status_bar_view;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setWindowStatusBar(Activity activity, int color) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup decorView = (ViewGroup)window.getDecorView();
        View fakeStatusBarView = decorView.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (fakeStatusBarView != null) {
            if (fakeStatusBarView.getVisibility() == View.GONE) {
                fakeStatusBarView.setVisibility(View.VISIBLE);
            }
            //注意这里需要将计算好的适配颜色放进来
            fakeStatusBarView.setBackgroundColor(color);
        } else {
            decorView.addView(createStatusBarView(activity,color));
        }
        setRootView(activity);



    }
    /**
     * 生成一个和状态栏大小相同的半透明矩形条
     *
     * @param activity 需要设置的activity
     * @param color    状态栏颜色值
     * @return 状态栏矩形条
     */
    private static View createStatusBarView(Activity activity, @ColorInt int color) {
        // 绘制一个和状态栏一样高的矩形
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(color);
        statusBarView.setId(FAKE_STATUS_BAR_VIEW_ID);
        return statusBarView;
    }
    /**
     * 设置根布局参数
     */
    private static void setRootView(Activity activity) {
        ViewGroup parent = (ViewGroup) activity.findViewById(android.R.id.content);
        for (int i = 0, count = parent.getChildCount(); i < count; i++) {
            View childView = parent.getChildAt(i);
            if (childView instanceof ViewGroup) {
                childView.setFitsSystemWindows(true);
                ((ViewGroup) childView).setClipToPadding(true);
            }
        }
    }
    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    private static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        Log.d(STATUS_BAR_TAG,context.getResources().getDimensionPixelSize(resourceId)+"");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}

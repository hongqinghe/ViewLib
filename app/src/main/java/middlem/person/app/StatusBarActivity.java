package middlem.person.app;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import person.middlem.viewmodule.statusBar.StatusBarCompat;

public class StatusBarActivity extends FragmentActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
//        StatusKitkatBarImpl statusKitkatBar=new StatusKitkatBarImpl();
//        statusKitkatBar.setWindowStatusBar(this,getResources().getColor(R.color.common_red));
        StatusBarCompat.setStatusBarColorTranslucent(this,getResources().getColor(R.color.white),true);
//        person.middlem.viewmodule.statusBar.StatusBarCompat.setStatusBarColorTranslucent(this,getResources().getColor(R.color.white));
//        StatusBarUtil.setColor(this,getResources().getColor(R.color.white));
        String brand = Build.BRAND;
        /**
         * android  4.4版本设置状态栏颜色（
         *兼容4.4版本必须设置“android:fitsSystemWindows="true"或者
         *统一设置
         *ViewGroup mContentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
         *View mChildView = mContentView.getChildAt(0);
         *if (mChildView != null) { mChildView.setFitsSystemWindows(true);}
         *注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
         *不设置会造成contentView向上顶，视图丢失
         */


//        Window window = this.getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
//        View statusBarView = new View(window.getContext());
//        int statusBarHeight = getStatusBarHeight(window.getContext());
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, statusBarHeight);
//        params.gravity = Gravity.TOP;
//        statusBarView.setLayoutParams(params);
//        statusBarView.setBackgroundColor(getResources().getColor(R.color.common_red));
//        decorViewGroup.addView(statusBarView);
//
//        ViewGroup mContentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
//        View mChildView = mContentView.getChildAt(0);
//        if (mChildView != null) {
//            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
//            mChildView.setFitsSystemWindows(true);
//        }

        /**
         *
         * 兼容5.0版本，根据版本判断，在5.0后系统提供了setStatusBarColor（int color）来设置状态栏的颜色
         */
//        Window windows = this.getWindow();
//        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
//        windows.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        windows.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////        需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
//        windows.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        //设置状态栏颜色
//        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT) {
//            windows.setStatusBarColor(getResources().getColor(R.color.common_red));
//        }

    }
}

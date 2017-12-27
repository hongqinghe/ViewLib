package person.middlem.viewmodule.statusBar;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;

/***********************************************
 * <P> desc:   系统状态栏设置
 * <P> Author: gongtong
 * <P> Date: 2017/12/12 13:48
 ***********************************************/

public class StatusBarCompat {
    static final IStatusBar mStatusBar;

    private static final int DEFAULT_STATUS_BAR_ALPHA = 80;
    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mStatusBar = new StatusMBarImpl();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mStatusBar = new StatusLollipopBarImpl();
        } else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            mStatusBar=new StatusKitkatBarImpl();
        }else {
            mStatusBar=new IStatusBar() {
                @Override
                public void setWindowStatusBar(Activity activity, int color) {

                }
            };
        }
    }

    /**
     * 设置状态栏的颜色
     * @param activity
     * @param color
     */
    public static void setStatusBarColor(Activity activity, @ColorInt int color){
        setStatusBarColor(activity,color,DEFAULT_STATUS_BAR_ALPHA,false);
    }

    /**
     * 设置状态栏的颜色
     *
     * @param activity
     * @param color      颜色值
     * @param alpha      alpha值 0-255
     * @param isDarkFont 是否设置颜色为纯色
     */
    public static void setStatusBarColor(Activity activity, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha, boolean isDarkFont) {
        mStatusBar.setWindowStatusBar(activity, calculateStatusColor(color, alpha));
        if (isDarkFont) {
            DarkFontCompat.setDarkFontStatusBar(activity, isDarkFont);
        }
    }

    /**
     * 设置状态栏的颜色(没有alpha)
     *
     * @param activity
     * @param color    颜色值
     * @param isDarkFont 是否设置颜色为纯色且改变默认的字体颜色为黑色
     */
    public static void setStatusBarColorTranslucent(Activity activity, @ColorInt int color, boolean isDarkFont) {
        // 适配6.0以上的机型 如果6.0以下，则就设置默认的alpha,设置纯色后看不清字体
        if (Build.VERSION.SDK_INT < 23&&!FlymeDarkFontImpl.isDisplayMe()&&!MIUIDarkFontImpl.isDisplayMe()) {
            setStatusBarColor(activity, color, DEFAULT_STATUS_BAR_ALPHA, isDarkFont);
        } else {
            setStatusBarColor(activity, color, 0, isDarkFont);
        }
    }

    /**
     * 计算状态栏颜色
     * @param color color值
     * @param alpha alpha值
     * @return 最终的状态栏颜色
     */
    private static int calculateStatusColor(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }
}

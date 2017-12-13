package person.middlem.viewmodule.statusBar;

import android.app.Activity;
import android.os.Build;
import android.view.View;

/***********************************************
 * <P> desc:   设置状态栏为纯色时的适配 目前适配机型  小米型号 4.4-7.0 魅族机型
 * <P> Author: gongtong
 * <P> Date: 2017/12/12 16:56
 ***********************************************/

public class DarkFontCompat {
    static final IDarkFont mDarkFont;

    static {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            mDarkFont = new MDarkFontImpl();
        }else if (MIUIDarkFontImpl.isDisplayMe()) {
            mDarkFont = new MIUIDarkFontImpl();
        } else if (FlymeDarkFontImpl.isDisplayMe()){
            mDarkFont=new FlymeDarkFontImpl();
        }else {
            mDarkFont = new IDarkFont() {
                @Override
                public void setDarkFontCompat(Activity activity, boolean isDarkFont) {

                }
            };
        }
    }

    public  static void setDarkFontStatusBar(Activity activity, boolean isDarkFont){
        mDarkFont.setDarkFontCompat(activity,isDarkFont);
    }
}

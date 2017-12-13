package person.middlem.viewmodule.statusBar;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * 魅族手机适配
 */
class FlymeDarkFontImpl implements IDarkFont {
    static boolean isDisplayMe() {
        return Build.DISPLAY.startsWith("Flyme");
    }

    @Override
    public void setDarkFontCompat(Activity activity, boolean isDarkFont) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        try {
            Field darkFlag = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            darkFlag.setAccessible(true);
            meizuFlags.setAccessible(true);
            int bit = darkFlag.getInt(null);
            int value = meizuFlags.getInt(params);
            if (isDarkFont) {
                value |= bit;
            } else {
                value &= ~bit;
            }
            meizuFlags.setInt(params, value);
            activity.getWindow().setAttributes(params);
            darkFlag.setAccessible(false);
            meizuFlags.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

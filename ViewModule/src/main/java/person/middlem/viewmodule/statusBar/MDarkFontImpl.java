package person.middlem.viewmodule.statusBar;

import android.app.Activity;
import android.view.View;


class  MDarkFontImpl implements IDarkFont{
        @Override
        public void setDarkFontCompat(Activity activity, boolean isDarkFont) {
            // 设置浅色状态栏时的界面显示
            View decor = activity.getWindow().getDecorView();
            int ui = decor.getSystemUiVisibility();
            if (isDarkFont) {
                ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            decor.setSystemUiVisibility(ui);
        }
    }
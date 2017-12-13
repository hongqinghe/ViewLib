package person.middlem.viewmodule.statusBar;

import android.app.Activity;
import android.view.Window;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/12/12 10:30
 ***********************************************/

interface IStatusBar {
  /**
   *
   * @param activity
   * @param color 状态栏颜色
   */
  void  setWindowStatusBar(Activity activity, int color);
}

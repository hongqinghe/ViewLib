package person.middlem.viewmodule.system;

import android.app.Activity;

import java.util.Stack;

/***********************************************
 * <P> dec:  activity 入栈管理类
 * <P> Author: gongtong
 * <P> Date: 17-8-3.
 * <P> Copyright  2008 二维火科技
 ***********************************************/

public class TDFActivityStackManager {
    private static Stack<Activity> activityStack;
    private static TDFActivityStackManager instance;

    public static TDFActivityStackManager getInstance() {
        if (instance == null) {
            synchronized (TDFActivityStackManager.class) {
                if (instance == null) {
                    instance = new TDFActivityStackManager();
                    activityStack = new Stack<>();
                }
            }
        }
        return instance;
    }

    /**
     * 添加activity入栈
     * @param activity
     */
    public  void addStackActivity(Activity activity) {
        if (activity != null) {
            activityStack.push(activity);
        }
    }

    /**
     * 弹出所有activity
     */
    public void popStackActivity() {
        while (true) {
            Activity activity = getCurrentActivity();
            if (activity==null) {
                instance = null;
                activityStack = null;
                break;
            }
            popActivity(activity);
        }
    }

    public void popActivity(Activity activity) {
        if (null != activity) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    private Activity getCurrentActivity() {
        Activity activity = null;
        if (!activityStack.isEmpty()) {
            activity = activityStack.lastElement();
        }
        return activity;
    }

    /**
     * 销毁除了activity和AppSplash以外的activity
     *
     * @param activity
     */
    public void finishActivityExcept(Activity activity) {
        if (activity == null) {
            return;
        }
        for (Activity activity1 : activityStack) {
            if (activityStack.firstElement().equals(activity1)) {
                activity.finish();
            }
        }
    }

    /**
     * 销毁所有的Activity.
     */
    public void finishAllLiveActivity() {
        for (Activity activity : activityStack) {
            if (!activity.getClass().getSimpleName().equals("AppSplash")) {
                activity.finish();
            }
        }
    }

    /**
     * 微信登录页面退出，销毁所有的Activity.
     */
    public void finishAllActivity() {
        for (Activity activity : activityStack) {
            activity.finish();
        }
    }

}

package person.middlem.viewmodule.focus;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import static person.middlem.viewmodule.focus.FocusTag.FOCUS_TAG;

/***********************************************
 * <P> desc:
 * <P> Author: gongTong
 * <P> Date: 2018/7/31 10:01
 ***********************************************/
public class FocusRl extends RelativeLayout {
    public FocusRl(Context context) {
        super(context);
    }

    public FocusRl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FocusRl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public View findFocus() {
        Log.d(FOCUS_TAG, "Rl findFocus");
        return super.findFocus();

    }

    @Override
    public View focusSearch(int direction) {
        Log.d(FOCUS_TAG, "Rl focusSearch");
        return super.focusSearch(direction);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        Log.d(FOCUS_TAG, "Rl requestFocus");
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        Log.d(FOCUS_TAG, "Rl requestChildFocus");
        super.requestChildFocus(child, focused);
    }
}

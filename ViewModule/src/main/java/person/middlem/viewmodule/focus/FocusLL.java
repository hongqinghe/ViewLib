package person.middlem.viewmodule.focus;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import static person.middlem.viewmodule.focus.FocusTag.FOCUS_TAG;

/***********************************************
 * <P> desc:
 * <P> Author: gongTong
 * <P> Date: 2018/7/31 10:02
 ***********************************************/
public class FocusLL  extends LinearLayout{



    public FocusLL(Context context) {
        super(context);
    }

    public FocusLL(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FocusLL(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View findFocus() {
        Log.d(FOCUS_TAG, "ll findFocus");
        return super.findFocus();

    }

    @Override
    public View focusSearch(int direction) {
        Log.d(FOCUS_TAG, "ll focusSearch");
        return super.focusSearch(direction);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        Log.d(FOCUS_TAG, "ll requestFocus");
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        Log.d(FOCUS_TAG, "ll requestChildFocus");
        super.requestChildFocus(child, focused);
    }
}

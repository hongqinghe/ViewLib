package person.middlem.viewmodule.focus;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static person.middlem.viewmodule.focus.FocusTag.FOCUS_TAG;

/***********************************************
 * <P> desc:
 * <P> Author: gongTong
 * <P> Date: 2018/7/31 10:08
 ***********************************************/
public class ChildFocusView  extends EditText {
    public ChildFocusView(Context context) {
        super(context);
    }

    public ChildFocusView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildFocusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View findFocus() {
        Log.d(FOCUS_TAG, "childEditText findFocus");
        return super.findFocus();

    }

    @Override
    public View focusSearch(int direction) {
        Log.d(FOCUS_TAG, "childEditText focusSearch");
        return super.focusSearch(direction);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        Log.d(FOCUS_TAG, "childEditText requestFocus");
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        Log.d(FOCUS_TAG, "childEditText onFocusChanged");
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }
}

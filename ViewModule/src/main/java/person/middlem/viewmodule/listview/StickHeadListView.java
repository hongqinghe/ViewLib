package person.middlem.viewmodule.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/15 14:34
 ***********************************************/

public class StickHeadListView extends ListView {
    public StickHeadListView(Context context) {
        super(context);
    }

    public StickHeadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

  public void bindHeadView(View view){
    this.setOnScrollListener(new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    });

  }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }
}

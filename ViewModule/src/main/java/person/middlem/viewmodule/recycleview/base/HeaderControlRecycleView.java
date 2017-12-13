package person.middlem.viewmodule.recycleview.base;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;


/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/12/1 13:52
 ***********************************************/


@RequiresApi(api = Build.VERSION_CODES.M)
public class HeaderControlRecycleView extends RecyclerView implements Scrollable{
    private static final  String RECYCLEVIEW_TAG="recycleView";
    public HeaderControlRecycleView(Context context) {
        this(context,null);
    }

    public HeaderControlRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int left, int top, int oldLeft, int oldTop) {
        super.onScrollChanged(left, top, oldLeft, oldTop);
        Log.d(RECYCLEVIEW_TAG, "onScrollChanged:     left     :" + left + "    top        :" + top + "   oldLeft   :  " + oldLeft + "   oldTop   :" + oldTop);
        if(getChildCount()>0){
            int firstPosition = getChildAdapterPosition(getChildAt(0));
            int lastPosition=getChildAdapterPosition(getChildAt(getChildCount()-1));

        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(RECYCLEVIEW_TAG,"onLayout:        change"+changed+"   left   :"+left+"top        :"+top+"    right   : "+right+"    bottom  :"+bottom);
    }


    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        Log.d(RECYCLEVIEW_TAG,"onScrolled :     dx  :"+dx+"   dy   :" +dy);
    }


    @Override
    public void addScrollViewCallbacks(ObservableScrollViewCallbacks listener) {

    }

    @Override
    public void removeScrollViewCallbacks(ObservableScrollViewCallbacks listener) {

    }

    @Override
    public void clearScrollViewCallbacks() {

    }

    @Override
    public void scrollVerticallyTo(int y) {

    }

    @Override
    public int getCurrentScrollY() {
        return 0;
    }

    @Override
    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {

    }
}

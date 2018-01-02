package person.middlem.viewmodule;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import middlem.person.utilsmodule.ConvertUtils;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/10/27 15:47
 * <P> Copyright  2008 二维火科技
 ***********************************************/
public class TDFHelpView extends AppCompatImageView implements View.OnTouchListener {
    private View viewGroup;
    private int lastX;
    private int lastY;
    private int rootWidth;
    private int rootHeight;
    private boolean isDrag;
    private int padding;
    private int moveX;
    private int moveY;

    public TDFHelpView(Context context) {
        this(context, null);
    }

    public TDFHelpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
        padding = ConvertUtils.dip2px(context, 5);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnTouchListener(this);
    }

    public boolean isDragMove() {
        return isDrag;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (viewGroup == null) {
            viewGroup = this;
            if (viewGroup == null)
                return false;
            ViewGroup rootView = (ViewGroup) viewGroup.getParent();
            if (rootView == null)
                return false;
            rootWidth = rootView.getWidth();
            rootHeight = rootView.getHeight();
        }
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                moveX = 0;
                moveY = 0;
                isDrag = false;
                break;
            /**
             * layout(l,t,r,b)
             * l  Left position, relative to parent
             t  Top position, relative to parent
             r  Right position, relative to parent
             b  Bottom position, relative to parent
             * */
            case MotionEvent.ACTION_MOVE: {
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;
                moveX += Math.abs(dx);
                moveY += Math.abs(dy);

                int left = viewGroup.getLeft() + dx;
                int top = viewGroup.getTop() + dy;
                int right = viewGroup.getRight() + dx;
                int bottom = viewGroup.getBottom() + dy;
                if (left < 0) {
                    left = 0;
                    right = left + viewGroup.getWidth();
                  }
                if (right > rootWidth) {
                    right = rootWidth;
                    left = right - viewGroup.getWidth();
                }
                if (top < 0) {
                    top = 0;
                    bottom = top + viewGroup.getHeight();
                }
                if (bottom > rootHeight) {
                    bottom = rootHeight;
                    top = bottom - viewGroup.getHeight();
                }
//                if (right>=rootWidth-viewGroup.getWidth()*2-padding*2&&bottom>=rootHeight/2-viewGroup.getHeight()&&bottom<=rootHeight/2-padding*2){
////                    top-=100;
//                    bottom-=100;
//                    top-=100;
//                }

                viewGroup.layout(left, top, right, bottom);
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            }
            case MotionEvent.ACTION_UP: {
                if (moveX < ViewConfiguration.get(getContext()).getScaledTouchSlop()
                        && moveY < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    return false;
                }
                isDrag = true;
                int left = viewGroup.getLeft();
                int top = viewGroup.getTop();
                int right = viewGroup.getRight();
                int bottom = viewGroup.getBottom();

                int centerX = left + viewGroup.getWidth() / 2;
                int centerY = top + viewGroup.getHeight() / 2;

                if (centerX < rootWidth / 2) {
                    if (centerY < rootHeight / 2) {
                        if (centerX < centerY) {
                            left = padding;
                            right = left + viewGroup.getWidth();
                        } else {
                            top = padding;
                            bottom = top + viewGroup.getHeight();
                        }
                    } else {
                        int bottomHeight = rootHeight - centerY;
                        if (centerX < bottomHeight) {
                            left = padding;
                            right = left + viewGroup.getWidth();
                        } else {
                            bottom = rootHeight - padding;
                            top = bottom - viewGroup.getHeight();
                        }
                    }
                } else {
                    int distanceRight = rootWidth - centerX;
                    if (centerY<rootHeight/2-100)
                    if (centerY < rootHeight / 2) {
                        if (distanceRight < centerY) {
                            right = rootWidth - padding;
                            left = right - viewGroup.getWidth();
                        } else {
                            top = padding;
                            bottom = top + viewGroup.getHeight();
                        }
                    } else {
                        int bottomHeight = rootHeight - centerY;
                        if (distanceRight < bottomHeight) {
                            right = rootWidth - padding;
                            left = right - viewGroup.getWidth();
                        } else {
                            bottom = rootHeight - padding;
                            top = bottom - viewGroup.getHeight();
                        }
                    }
                }
                //  Log.d("layout-position",left+"--"+top+"---"+right+"---"+bottom);

//                if (right>=rootWidth-viewGroup.getWidth()*2-padding*2&&bottom>=rootHeight/2-viewGroup.getHeight()&&bottom<=rootHeight/2+padding){
//                    bottom-=200;
//                    top-=200;
//                }
//
//                if (right>=rootWidth-viewGroup.getWidth()*2-padding*2&&bottom>=rootHeight/2-viewGroup.getHeight()*3&&bottom<=rootHeight/2+padding+viewGroup.getHeight()*2){
//                    bottom-=200;
//                    top-=200;
//                }
                viewGroup.layout(left, top, right, bottom);
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                break;
            }
        }
        return isDrag;
    }
}

package person.middlem.viewmodule.helpview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;

import middlem.person.utilsmodule.ConvertUtils;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/10/27 15:47
 * <P> Copyright  2008 二维火科技
 ***********************************************/
public class TDFHelpViewNew extends AppCompatImageView implements View.OnTouchListener {
    private View viewGroup;
    private int lastX;
    private int lastY;
    private int rootWidth;
    private int rootHeight;
    private boolean isDrag;
    private int padding;
    private int moveX;
    private int moveY;

    public TDFHelpViewNew(Context context) {
        this(context, null);
    }

    public TDFHelpViewNew(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
        padding = ConvertUtils.dip2px(context, 10);
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
    public boolean onTouch(final View v, MotionEvent event) {
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
               final int left = padding;
               final int right = viewGroup.getWidth()+padding;
               final int bottom = viewGroup.getBottom();
               final int top = viewGroup.getTop();
                ValueAnimator animation=ValueAnimator.ofInt(right,left);
                animation.setDuration(300);
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int animatedValue = (int) animation.getAnimatedValue();
                        viewGroup.clearAnimation();
//                        viewGroup.setAnimation();
                        viewGroup.layout(left, top, right, bottom);
                    }
                });
                AnimationSet animationSet=new AnimationSet(true);
//                animationSet.addAnimation(animation);
                viewGroup.startAnimation(new AnimationSet(true));
//                animation.start();
                TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,-(event.getRawX()-right-padding)/(rootWidth-padding),Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
//                translateAnimation.setInterpolator(new OvershootInterpolator());
                translateAnimation.setDuration(300);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.clearAnimation();
                        viewGroup.layout(left, top, right, bottom);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                viewGroup.startAnimation(translateAnimation);

//                viewGroup.layout(left, top, right, bottom);
//                Animation animation1=new ValueAnimator();

                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                break;
            }
        }
        return isDrag;
    }
}

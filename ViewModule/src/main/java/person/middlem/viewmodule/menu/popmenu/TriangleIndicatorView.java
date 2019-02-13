package person.middlem.viewmodule.menu.popmenu;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import middlem.person.utilsmodule.comutils.ConvertUtils;
import person.middlem.viewmodule.R;


/**
 * 三角形指示器
 * Created by HMY on 2016/10/22/022.
 */
public class TriangleIndicatorView extends View {

    private int mWidth = 16;
    private int mHeight = 8;
    private int mColor = getResources().getColor(R.color.white_f90);
    private boolean mIsUp = true;

    public TriangleIndicatorView(Context context) {
        super(context);

        init();
    }

    public TriangleIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        mWidth = ConvertUtils.dip2px(getContext(), mWidth);
        mHeight = ConvertUtils.dip2px(getContext(), mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(mColor);

        Path path = new Path();
        if (mIsUp) {
            path.moveTo(mWidth / 2, 0);// 此点为多边形的起点
            path.lineTo(0, mHeight);
            path.lineTo(mWidth, mHeight);
        } else {
            path.moveTo(0, 0);// 此点为多边形的起点
            path.lineTo(mWidth, 0);
            path.lineTo(mWidth / 2, mHeight);
        }

        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, p);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        getLayoutParams().height = mHeight;
        getLayoutParams().width = mWidth;
    }

    public int getRealWidth() {
        return mWidth;
    }

    public int getRealHeight(){
        return mHeight;
    }

    public void setColor(int color) {
        mColor = color;
        invalidate();
    }

    /**
     * 设置方向
     *
     * @param isUp 是否向上
     */
    public void setOrientation(boolean isUp) {
        mIsUp = isUp;
    }

}

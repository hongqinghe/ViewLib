package person.middlem.viewmodule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/***********************************************
 * <P> desc:    每个item之间的分割线(统一配置)
 * <P> Author: gongtong
 * <P> Date: 2017/12/15 11:32
 ***********************************************/

public class TDFDividerLineView extends View {
    public TDFDividerLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        initView(context);
    }

    public TDFDividerLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        initView(context);
    }


    private void initView(Context context) {
        this.setBackgroundColor(getResources().getColor(R.color.white_0c3));
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        Paint paint = new Paint();
//        // canvas的宽度和高度
//        int lineWidth = getWidth();
//        int lineHeight = 2;
//        // 设置线的粗细为canvas的高度
//        paint.setStrokeWidth(lineHeight);
//        // 画左端的白线，假设两端留白长度是30
//        paint.setColor(getResources().getColor(R.color.white_0c3));
//        canvas.drawLine(0, lineHeight / 2, 30, lineHeight / 2, paint);
//        // 画中间的分割线
//        paint.setColor(Color.BLACK);
//        canvas.drawLine(30, lineHeight / 2, lineWidth - 30, lineHeight / 2, paint);
//        // 画右端的白线，假设两端留白长度是30
//        paint.setColor(Color.WHITE);
//        canvas.drawLine(lineWidth - 30, lineHeight / 2, lineWidth, lineHeight / 2, paint);
//    }
}

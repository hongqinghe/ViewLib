package person.middlem.viewmodule;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.StandaloneActionMode;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import middlem.person.utilsmodule.ConvertUtils;

/***********************************************
 * <P> desc:  实现一个可以切换的tabView
 * <P> Author: gongtong
 * <P> Date: 2017/12/27 10:04
 ***********************************************/

public class TextTabView extends FrameLayout {
    /**
     * tab高度
     */
    private int tabHeight;

    private int  iconGravity;
    /**
     * 文本 选中未选中
     */
    private String textUnSelectSize;
    private String textSelectSize;
    private int textUnselectColor;
    private int textSelectColor;
    /**
     * 分割线的颜色(每个tab之间)
     */
    private int dividerColor;
    private float dividerWidth;
    private float dividerPadding;
    private boolean isShowDivider;
    private static final int  DEFAUTLT_DIVIDER_COLOR= Color.WHITE;
    /**
     * 指示器
     */
    private int indicatorColor;
    private float indicatorHeight;
    private float indicatorWidth;
    private boolean isShowIndicator;
    private static final int DEFALT_INDICATOR_COLOR=Color.BLUE;

    public TextTabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TextTabView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readStyleParameters(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 读取样式
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void readStyleParameters(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextTabView);
        if (typedArray!=null) {
            dividerColor = typedArray.getColor(R.styleable.TextTabView_divider_color, DEFAUTLT_DIVIDER_COLOR);
            dividerWidth = typedArray.getDimension(R.styleable.TextTabView_divider_width, ConvertUtils.dip2px(context, 12));
            dividerPadding = typedArray.getDimension(R.styleable.TextTabView_divider_padding, ConvertUtils.dip2px(context, 5));

            indicatorColor = typedArray.getColor(R.styleable.TextTabView_indicator_color, DEFALT_INDICATOR_COLOR);
            indicatorWidth=typedArray.getDimension(R.styleable.TextTabView_indicator_width,ConvertUtils.dip2px(context,5));
            indicatorHeight=typedArray.getDimension(R.styleable.TextTabView_indicator_height,ConvertUtils.dip2px(context,4));


            typedArray.recycle();
        }


    }

    private void initView() {

    }
}

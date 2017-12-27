package person.middlem.viewmodule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

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
    private int dividerHeight;
    private int dividerwidth;
    /**
     * 指示器
     */
    private int indicatorColor;
    private int indicatorHeight;
    private int indicatorWidth;


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

    }

    private void initView() {

    }
}

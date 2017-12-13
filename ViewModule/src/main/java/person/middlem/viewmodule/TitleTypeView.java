package person.middlem.viewmodule;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
/***********************************************
 * <P> desc:   头部类型view:头部状态view由{@link AutoWrapView} 组成
 *             底部的分栏条 背景设置通过资源文件【item_type_column_style】设置
 *             字体样式统一由【item_type_text_style】设置
 * <P> Author: gongtong
 * <P> Date: 2017/12/7 14:01
 ***********************************************/

public class TitleTypeView extends LinearLayout {

    private AutoWrapView autoWrapView;

    public TitleTypeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TitleTypeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.title_type_view, this);
        autoWrapView = view.findViewById(R.id.autoWrapView);
    }

    public AutoWrapView getAutoWrapView() {
        return autoWrapView;
    }

}

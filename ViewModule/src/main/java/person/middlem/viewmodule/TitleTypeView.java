package person.middlem.viewmodule;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/***********************************************
 * <P> desc:   头部类型view:头部状态view由{@link AutoWrapView} 组成
 *             底部的分栏条 背景设置通过资源文件【item_type_column_style】设置
 *             字体样式统一由【item_type_text_style】设置
 * <P> Author: gongtong
 * <P> Date: 2017/12/7 14:01
 ***********************************************/

public class TitleTypeView extends LinearLayout {

    private AutoWrapView autoWrapView;

    private String leftContent;
    private String rightContent;
    private String autoContent1;
    private String autoContent2;
    private String autoContent3;
    private String autoContent4;
    private TextView tvLeft;
    private TextView tvRight;
    private List<String> dataList;

    public TitleTypeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TitleTypeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        readStyleParameters(context,attrs);
    }

    @SuppressLint("ResourceAsColor")
    private void readStyleParameters(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleTypeView);
        if (typedArray!=null){
            try {
                autoContent1=typedArray.getString(R.styleable.TitleTypeView_auto_content_1);
                autoContent2=typedArray.getString(R.styleable.TitleTypeView_auto_content_2);
                autoContent3=typedArray.getString(R.styleable.TitleTypeView_auto_content_3);
                autoContent4=typedArray.getString(R.styleable.TitleTypeView_auto_content_4);
                leftContent=typedArray.getString(R.styleable.TitleTypeView_text_left);
                rightContent=typedArray.getString(R.styleable.TitleTypeView_text_right);
            }finally {
                typedArray.recycle();
            }
        }
        setContent();
    }

    private void setContent() {
        tvLeft.setText(leftContent);
        tvRight.setText(rightContent);
        dataList.clear();
        dataList.add(autoContent1);
        dataList.add(autoContent2);
        dataList.add(autoContent3);
        dataList.add(autoContent4);
        autoWrapView.setDataList(dataList);
    }

    /**
     *  设置类型参数
     * @param leftContent
     * @param rightContent
     */
    public void setTypeContent(String leftContent, String rightContent){
        tvLeft.setText(leftContent);
        tvRight.setText(rightContent);
    }
    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.title_type_view, this);
        autoWrapView = (AutoWrapView) view.findViewById(R.id.autoWrapView);
        tvLeft = (TextView) view.findViewById(R.id.textLeft);
        tvRight = (TextView)view.findViewById(R.id.textRight);
        dataList = new ArrayList<>();
    }

    public AutoWrapView getAutoWrapView() {
        return autoWrapView;
    }

}

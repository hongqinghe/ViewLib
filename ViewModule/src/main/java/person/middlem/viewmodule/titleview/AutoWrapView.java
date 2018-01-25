package person.middlem.viewmodule.titleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import middlem.person.utilsmodule.ConvertUtils;
import middlem.person.utilsmodule.DisplayMetricsUtil;
import person.middlem.viewmodule.R;

/***********************************************
 * <P> desc:   一个自动换行的头部TextView（可以自动设置一行显示的数量（默认设置两个））
 * <P> Author: gongtong
 * <P> Date: 2017/12/6 19:10
 ***********************************************/

public class AutoWrapView extends LinearLayout {

    private TDFFlowContainer flowContainer;
    private static final float DEFAULT_MARGIN_LEFT = 10;
    private static final int DEFAULT_TEXT_COLOR = R.color.white_30;
    private static final int DEFAULT_TEXT_SIZE = 14;
    private static final int DEFAULT_TEXT_NUM = 2;
    private float marginLeft;
    private List<String> dataList;
    private LayoutInflater inflater;
    private Context mContext;
    private int textColor;
    private int textSize;
    /**
     * 一行显示view的数量
     */
    private int num;
    private List<TextView> textViewList;

    public AutoWrapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AutoWrapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        this.mContext = context;
        readStyleParameters(context, attrs);
    }

    @SuppressLint("ResourceAsColor")
    private void readStyleParameters(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoWrapView);
        if (typedArray != null) {
            try {
                marginLeft = typedArray.getDimension(R.styleable.AutoWrapView_margin_left, DEFAULT_MARGIN_LEFT);
                textColor = typedArray.getColor(R.styleable.AutoWrapView_text_color, DEFAULT_TEXT_COLOR);
                textSize = typedArray.getInteger(R.styleable.AutoWrapView_text_size, DEFAULT_TEXT_SIZE);
                num = typedArray.getInteger(R.styleable.AutoWrapView_text_num, DEFAULT_TEXT_NUM);
            } finally {
                typedArray.recycle();
            }
        }
    }

    private void initView(Context context) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.auto_wrap_view, this);
        flowContainer = (TDFFlowContainer) view.findViewById(R.id.flowContainer);
    }

    /**
     * 设置数据集合
     *
     * @param stringList
     */
    public void setDataList(List<String> stringList) {
        this.dataList = stringList;
        initDataView(mContext);
    }

    private void initDataView(Context context) {
        flowContainer.removeAllViews();
        DisplayMetricsUtil.init(context);
        int dipScreenWidth = DisplayMetricsUtil.getDipScreenWidth();
        float parentWidth = dipScreenWidth - marginLeft * 2;
        if (dataList == null) {
            return;
        }
        TextView textView = null;
        textViewList = new ArrayList<>();
        for (String value : dataList) {
            textView = (TextView) inflater.inflate(R.layout.textview_item, null, false);
            textView.setWidth(ConvertUtils.dip2px(context, parentWidth / num));//设置每个view显示的width，根据每行的num决定
            textView.setText(value);
            textView.setTextSize(textSize);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine();
            textView.setTextColor(textColor);
            textView.setPadding((int) ConvertUtils.dip2px(context, marginLeft), 0, 0, 0);
            textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
            textViewList.add(textView);
            flowContainer.addView(textView);
        }
    }

    public void updateList(List<String> stringList) {
        String value;
        if (textViewList==null||textViewList.isEmpty() || stringList.size() > textViewList.size() || Math.abs(stringList.size() - textViewList.size()) > 1) {
            setDataList(stringList);
        } else {
            for (int i = 0; i < textViewList.size(); i++) {
                try {
                    value = stringList.get(i);
                } catch (IndexOutOfBoundsException e) {
                    value = "";
                }
                if (value == null) {
                    flowContainer.removeView(textViewList.get(i));
                    textViewList.get(i).setVisibility(GONE);
                } else {
                    textViewList.get(i).setText(value);
                }
            }
        }
    }
}

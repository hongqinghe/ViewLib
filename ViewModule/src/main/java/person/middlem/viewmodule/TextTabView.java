package person.middlem.viewmodule;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import middlem.person.utilsmodule.ConvertUtils;
import middlem.person.utilsmodule.LogUtils;
import middlem.person.utilsmodule.SystemUtils;

/***********************************************
 * <P> desc:  实现一个可以切换的tabView
 * <P> Author: gongtong
 * <P> Date: 2017/12/27 10:04
 ***********************************************/

public class TextTabView extends FrameLayout {
    private static final String TAB_VIEW_TAG = "textTabView";
    /**
     * 文本 选中未选中
     */
    private int textUnSelectSize;
    private int textSelectSize;
    private int textUnSelectColor;
    private int textSelectColor;

    /**
     * 指示器
     */
    private int indicatorColor;
    private float indicatorHeight;
    private float indicatorWidth;
    private boolean isShowIndicator;
    private static final int DEFAULT_INDICATOR_COLOR = Color.BLUE;

    private Context mContext;

    private List<TabDataVo> tabDataVos;

    /**
     * 是否含有tabIcon
     */
    private boolean showTabIcon;

    /**
     * 存贮View每个tab的ViewGroup容器
     */
    private LinearLayout mViewContainer;

    private int mCurrectPotion;

    public TextTabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextTabView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);

        mContext = context;

        mViewContainer = new LinearLayout(context);
        addView(mViewContainer);
        readStyleParameters(context, attrs, defStyleAttr);
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
        if (typedArray != null) {

            indicatorColor = typedArray.getColor(R.styleable.TextTabView_indicator_color, DEFAULT_INDICATOR_COLOR);
//            indicatorWidth = typedArray.getDimension(R.styleable.TextTabView_indicator_width, ConvertUtils.dip2px(context, 5));
            indicatorHeight = typedArray.getDimension(R.styleable.TextTabView_indicator_height, ConvertUtils.dip2px(context, 4));
            isShowIndicator = typedArray.getBoolean(R.styleable.TextTabView_indicator_show_line, true);

            textSelectSize = typedArray.getInt(R.styleable.TextTabView_text_select_size, 15);
            textUnSelectSize = typedArray.getInt(R.styleable.TextTabView_text_unselect_szie, 15);
            textSelectColor = typedArray.getColor(R.styleable.TextTabView_text_select_color, Color.BLUE);
            textUnSelectColor = typedArray.getColor(R.styleable.TextTabView_text_unselect_color, Color.BLACK);
            showTabIcon = typedArray.getBoolean(R.styleable.TextTabView_icon_show, false);
            typedArray.recycle();
        }


    }

    public void setTabDatas(List<TabDataVo> tabDataVos) {
        if (tabDataVos == null || tabDataVos.size() == 0) {
            throw new IllegalArgumentException("tabDatas allow't null");
        }
        this.tabDataVos = tabDataVos;
        notifyDataChanges();

    }

    public void setTabSelect(int position) {
        mCurrectPotion = position;
        updateTabSelection(position);
        invalidate();
    }

    private void updateTabSelection(int position) {
        mCurrectPotion = position;
        LogUtils.d(TAB_VIEW_TAG, "update tab view");
        if (tabDataVos != null && tabDataVos.size() > 0) {
            int count = tabDataVos.size();
            for (int i = 0; i < count; i++) {
                View selectView = mViewContainer.getChildAt(i);
                boolean isSelect = i == position;
                TextView tabText = selectView.findViewById(R.id.tab_text);
                ImageView tabIcon = selectView.findViewById(R.id.tab_icon);
                View tabLine = selectView.findViewById(R.id.tab_line);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, ConvertUtils.dip2px(mContext, indicatorHeight));
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                tabLine.setLayoutParams(layoutParams);
                tabLine.setBackgroundColor(indicatorColor);
                tabText.setTextSize(isSelect ? textSelectSize : textUnSelectSize);
                tabText.setTextColor(isSelect ? textSelectColor : textUnSelectColor);
                tabLine.setVisibility(isSelect ? VISIBLE : INVISIBLE);
                if (showTabIcon) {
                    tabIcon.setVisibility(VISIBLE);
                    tabIcon.setImageResource(isSelect ? tabDataVos.get(position).getTabSelectIcon() : tabDataVos.get(position).getTabUnSelectIcon());
                }
            }
        }
    }

    private void notifyDataChanges() {
        mViewContainer.removeAllViews();
        int count = this.tabDataVos.size();
        View tabView;
        for (int i = 0; i < count; i++) {
            tabView = LayoutInflater.from(mContext).inflate(R.layout.text_tab_hor, null);
            tabView.setTag(i);
            addTabView(i, tabView, mViewContainer);
        }
    }

    private void addTabView(final int position, View tabView, LinearLayout mViewContainer) {
        TextView tabText = tabView.findViewById(R.id.tab_text);
        tabText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textUnSelectSize);
        tabText.setTextColor(textUnSelectColor);
        tabText.setText(tabDataVos != null ? tabDataVos.get(position).getTabText() : "");
        ImageView tabIcon = tabView.findViewById(R.id.tab_icon);
        if (showTabIcon && tabDataVos != null && tabDataVos.get(position).getTabUnSelectIcon() == -1) {
            tabIcon.setImageResource(tabDataVos.get(position).getTabUnSelectIcon());
            tabIcon.setVisibility(VISIBLE);
        } else {
            tabIcon.setVisibility(GONE);
        }
        tabView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                if (mCurrectPotion != position)
                    updateTabSelection(position);
                if (selectListener != null) {
                    LogUtils.d(TAB_VIEW_TAG, "click:" + position);
                    selectListener.onSelect(position);
                }
            }
        });
        /**
         * 每个自View占用的布局
         */
        LinearLayout.LayoutParams childLayoutParams = new LinearLayout.LayoutParams(SystemUtils.getScreenWidth(mContext) / tabDataVos.size(), LayoutParams.MATCH_PARENT, 1.0f);
        LayoutParams layoutParams = new LayoutParams(childLayoutParams);
        mViewContainer.addView(tabView, position, layoutParams);

    }

    /**
     * tabSelection tab选中事件
     */
    private OnTextTabSelectListener selectListener;

    public void setOnSelectListener(OnTextTabSelectListener onSelectListener) {
        this.selectListener = onSelectListener;
    }

    public interface OnTextTabSelectListener {
        void onSelect(int position);
    }
}

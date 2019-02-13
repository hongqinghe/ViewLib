package person.middlem.viewmodule.menu.popmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import person.middlem.viewmodule.R;


/**
 * Created by xiancai on 2018/12/25
 */
public class DropPopLayout extends LinearLayout {

    private TriangleIndicatorView mTriangleUpIndicatorView;
    private TriangleIndicatorView mTriangleDownIndicatorView;
    private LinearLayout mContainerLayout;

    private int mBackgroundResource = R.drawable.btn_common_grey_fill_3 ;

    public DropPopLayout(Context context) {
        super(context);
        initView();
    }

    public DropPopLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
        setGravity(Gravity.LEFT);

        mTriangleUpIndicatorView = new TriangleIndicatorView(getContext());
        mTriangleUpIndicatorView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT));
        addView(mTriangleUpIndicatorView);

        mContainerLayout = new LinearLayout(getContext());
        mContainerLayout.setOrientation(VERTICAL);
        mContainerLayout.setBackgroundResource(mBackgroundResource);

        addView(mContainerLayout);

        mTriangleDownIndicatorView = new TriangleIndicatorView(getContext());
        mTriangleDownIndicatorView.setOrientation(false);
        mTriangleUpIndicatorView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT));
        addView(mTriangleDownIndicatorView);
        mTriangleDownIndicatorView.setVisibility(GONE);
    }

    /**
     * 设置弹窗显示位置
     *
     * @param isUp true、在上面
     */
    public void setOrientation(boolean isUp) {
        if (isUp) {
            mTriangleUpIndicatorView.setVisibility(GONE);
            mTriangleDownIndicatorView.setVisibility(VISIBLE);
        } else {
            mTriangleUpIndicatorView.setVisibility(VISIBLE);
            mTriangleDownIndicatorView.setVisibility(GONE);
        }
    }

    public void setBackgroundResource(int backgroundResource) {
        mBackgroundResource = backgroundResource;
        if (mContainerLayout != null) {
            mContainerLayout.setBackgroundResource(backgroundResource);
        }
    }

    public void setTriangleIndicatorViewColor(int color) {
        mTriangleUpIndicatorView.setColor(color);
        mTriangleDownIndicatorView.setColor(color);
    }

    public void setBackgroundColor(int color) {
        mContainerLayout.setBackgroundColor(color);
    }

    public TriangleIndicatorView getTriangleUpIndicatorView() {
        return mTriangleUpIndicatorView;
    }

    public TriangleIndicatorView getTriangleDownIndicatorView() {
        return mTriangleDownIndicatorView;
    }

    public LinearLayout getContainerLayout() {
        return mContainerLayout;
    }
}

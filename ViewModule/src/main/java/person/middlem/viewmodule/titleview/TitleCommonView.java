package person.middlem.viewmodule.titleview;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import person.middlem.viewmodule.R;

/***********************************************
 * <P> desc:
 * <P> Author: gongTong
 * <P> Date: 2019/2/13 20:48
 ***********************************************/
public class TitleCommonView extends ConstraintLayout {


    private Context mContext;
    public TitleCommonView(Context context) {
        this(context, null);
    }

    public TitleCommonView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TitleCommonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        this.readStyleParameters(context, attrs);
    }

    private void readStyleParameters(Context context, AttributeSet attrs) {

    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.titlte_view_new, this);
//        Placeholder phLeft = view.findViewById(R.id.ph_left);
//        Placeholder phCenter = view.findViewById(R.id.ph_center);
//        Placeholder phRight = view.findViewById(R.id.ph_right);
//        phLeft.setEmptyVisibility(View.VISIBLE);
//        phRight.setEmptyVisibility(View.VISIBLE);
////        phCenter.setContentId(R.layout.title_left_view);
//        phCenter.setContentId(R.id.tv_3);
    }
}

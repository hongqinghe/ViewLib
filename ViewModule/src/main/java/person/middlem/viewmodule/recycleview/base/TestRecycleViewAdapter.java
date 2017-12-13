package person.middlem.viewmodule.recycleview.base;

import android.view.View;

import java.util.List;

import person.middlem.viewmodule.R;
import person.middlem.viewmodule.listview.StringData;
import person.middlem.viewmodule.recycleview.TestRecycleViewHolder;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/23 21:56
 ***********************************************/

public class TestRecycleViewAdapter extends DefaultAdapter<StringData>{

    public TestRecycleViewAdapter(List<StringData> infos) {
        super(infos);
    }
    public void setData(List<StringData >data){
        mInfos=data;
        notifyDataSetChanged();
    }
    public void loadMore(List<StringData> data){
        for (StringData datum : data) {
            mInfos.add(datum);
        }
        notifyDataSetChanged();
    }
    @Override
    public BaseHolder<StringData> getHolder(View v, int viewType) {
        return new TestRecycleViewHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_view;
    }
}

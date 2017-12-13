package person.middlem.viewmodule.recycleview;

import android.view.View;
import android.widget.TextView;

import person.middlem.viewmodule.R;
import person.middlem.viewmodule.listview.StringData;
import person.middlem.viewmodule.recycleview.base.BaseHolder;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/23 21:57
 ***********************************************/

public class TestRecycleViewHolder extends BaseHolder<StringData> {

    private final TextView content;

    public TestRecycleViewHolder(View itemView) {
        super(itemView);
        content = itemView.findViewById(R.id.content);
    }

    @Override
    public void setData(StringData data, int position) {
        content.setText(data.getContent());
    }
}

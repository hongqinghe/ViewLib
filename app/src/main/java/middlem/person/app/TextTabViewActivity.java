package middlem.person.app;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import middlem.person.utilsmodule.LogUtils;
import person.middlem.viewmodule.tabview.TabDataVo;
import person.middlem.viewmodule.tabview.TextTabView;

public class TextTabViewActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_tab_view);
        TextTabView textTabView = findViewById(R.id.text_tab_view);
        List<TabDataVo> tabDataVos = new ArrayList<>();
        TabDataVo tabDataVo=new TabDataVo("AA");
        TabDataVo tabDataVo1=new TabDataVo("BB");
        TabDataVo tabDataVo2=new TabDataVo("CC");
        tabDataVos.add(tabDataVo);
        tabDataVos.add(tabDataVo1);
        tabDataVos.add(tabDataVo2);
        textTabView.setTabDatas(tabDataVos);
        textTabView.setTabSelect(0);
        textTabView.setOnSelectListener(new TextTabView.OnTextTabSelectListener() {
            @Override
            public void onSelect(int position) {
                LogUtils.d("TextTabView","选中的position"+position);
            }
        });

        TextView text=findViewById(R.id.text);
//        text.setRotation(-45);
////        text.setRotationY(45);
    }
}

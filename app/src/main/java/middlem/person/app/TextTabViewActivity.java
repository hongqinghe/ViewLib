package middlem.person.app;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.TabDataVo;
import person.middlem.viewmodule.TextTabView;

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
    }
}

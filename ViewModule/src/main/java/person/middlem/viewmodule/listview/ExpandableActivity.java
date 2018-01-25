package person.middlem.viewmodule.listview;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.R;

public class ExpandableActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        ExpandableListView listView=findViewById(R.id.expandable_list);
        List<String> titleList=new ArrayList<>();
        titleList.add("A");
        titleList.add("B");
        titleList.add("C");
        List<String> contentList=new ArrayList<>();
        contentList.add("con");
        contentList.add("con1");
        contentList.add("con2");
        contentList.add("con3");
        ExpandAdapter expandAdapter=new ExpandAdapter(titleList,contentList,this);
        listView.setAdapter(expandAdapter);
    }
}

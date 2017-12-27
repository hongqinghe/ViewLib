package person.middlem.viewmodule.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.R;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private TestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView =  findViewById(R.id.listView);
        testAdapter=new TestAdapter(this,getStringList());
        listView.setAdapter(testAdapter);
        initEvent();
    }
    private void initEvent() {
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                System.out.println("count--------->"+listView.getMaxScrollAmount());
            }
        });
    }

    private List<StringData> getStringList() {
        List<StringData> stringList = new ArrayList<>();
        for (int i=0;i<=16;i++){
            if (i==1||i==3||i==5){
                StringData stringData=new StringData();
                stringData.setType("1");
                stringData.setTitle("title1");
                stringData.setContent("content1");
                stringList.add(stringData);
            } else {
                StringData stringData=new StringData();
                stringData.setType("2");
                stringData.setTitle("title2");
                stringData.setContent("content2");
                stringList.add(stringData);
            }
        }
        return stringList;
    }

    public void toSearch(View view) {
        listView.setFilterText("i");
    }
}

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

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                System.out.println("count--------->"+listView.getMaxScrollAmount());
            }
        });
    }

    private List<String> getStringList() {
        List<String> stringList = new ArrayList<>();
        for (int i=0;i<=16;i++){
            if (i==2){
                stringList.add("iiiiiiiiiiiiiiiii");
            }
            else stringList.add("sssss"+i);
        }
        return stringList;
    }

    public void toSearch(View view) {
        listView.setFilterText("i");
    }
}

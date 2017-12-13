package person.middlem.viewmodule.recycleview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.DataUtils;
import person.middlem.viewmodule.R;
import person.middlem.viewmodule.listview.StringData;
import person.middlem.viewmodule.recycleview.base.HeaderAndFooterRecyclerViewAdapter;
import person.middlem.viewmodule.recycleview.base.TestRecycleViewAdapter;

public class RecyCleViewActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private SwipeRefreshLayout refresh;
    private TestRecycleViewAdapter testRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_cle_view);
        recycleView = findViewById(R.id.recycleView);
        refresh = findViewById(R.id.refresh);
//        refresh.setRefreshing(false);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.setRefreshing(true);
                testRecycleViewAdapter.loadMore(DataUtils.getStringList(2));
                refresh.setRefreshing(false);
            }
        });
        List<StringData > stringData=new ArrayList<>();
        testRecycleViewAdapter = new TestRecycleViewAdapter(stringData);
        HeaderAndFooterRecyclerViewAdapter adapter = new HeaderAndFooterRecyclerViewAdapter(testRecycleViewAdapter);
        View header = getLayoutInflater().inflate(R.layout.item_devider_view, null);
        View footer = getLayoutInflater().inflate(R.layout.item_foot_view, null);

        adapter.addHeaderView(header);
        adapter.addFooterView(footer);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(adapter);

        testRecycleViewAdapter.setData(DataUtils.getStringList(1));
    }
}

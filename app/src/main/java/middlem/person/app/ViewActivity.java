package middlem.person.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import person.middlem.viewmodule.listview.ListViewActivity;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }
    public void toListView(View view){
        Intent intent=new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
}

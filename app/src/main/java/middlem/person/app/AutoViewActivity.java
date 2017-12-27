package middlem.person.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.AutoWrapView;
import person.middlem.viewmodule.TitleTypeView;

public class AutoViewActivity extends AppCompatActivity {

    private TitleTypeView titleTypeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_view);
//        StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.colorAccent),true);
        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.common_red));

        AutoWrapView autoWrap= (AutoWrapView) findViewById(R.id.autoWrapView);
        List<String > stringList=new ArrayList<>();
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        autoWrap.setDataList(stringList);


        titleTypeView = findViewById(R.id.titleTypeView);
    }

    public void update(View view) {
        List<String> list=new ArrayList<>();
        list.add("配货方：全部");
        list.add("配货方：全部");
        list.add("配货方：全部");
        titleTypeView.getAutoWrapView().updateList(list);
    }
}

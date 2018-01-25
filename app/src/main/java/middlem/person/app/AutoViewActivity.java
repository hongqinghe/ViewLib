package middlem.person.app;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.titleview.AutoWrapView;
import person.middlem.viewmodule.titleview.TitleTypeView;

public class AutoViewActivity extends AppCompatActivity {

    private TitleTypeView titleTypeView;
    WindowManager wm = null;
    WindowManager.LayoutParams wmParams = null;
    MyFloatView myFV = null;
    private TDFCustomerView tdfCustomerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_view);
//        StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.colorAccent),true);
        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.common_red));

        AutoWrapView autoWrap = (AutoWrapView) findViewById(R.id.autoWrapView);
        List<String> stringList = new ArrayList<>();
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        stringList.add("采购方：全部");
        autoWrap.setDataList(stringList);


        titleTypeView = findViewById(R.id.titleTypeView);

        createView();
        tdfCustomerView = new TDFCustomerView(this);
        tdfCustomerView.show();
        tdfCustomerView.setLocation(TDFCustomerView.LOCATION_LEFT_BOTTOM);
    }

    public void update(View view) {
        List<String> list = new ArrayList<>();
        list.add("配货方：全部");
        list.add("配货方：全部");
        list.add("配货方：全部");
        titleTypeView.getAutoWrapView().updateList(list);
    }

    @Override
    protected void onPause() {
        super.onPause();
        tdfCustomerView.dismiss();
    }

    private void createView() {
        myFV = new MyFloatView(getApplicationContext());
        myFV.setImageResource(R.mipmap.ic_launcher);
        //获取WindowManager
        wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        //设置LayoutParams(全局变量）相关参数
        wmParams = ((App) getApplication()).getMywmParams();
        wmParams.type = 2002;
        //wmParams.format=1;
        wmParams.flags |= 8;


        wmParams.gravity = Gravity.LEFT | Gravity.TOP;   //调整悬浮窗口至左上角
        //以屏幕左上角为原点，设置x、y初始值
        wmParams.x = 0;
        wmParams.y = 0;

        //设置悬浮窗口长宽数据
        wmParams.width = 40;
        wmParams.height = 40;

        //显示myFloatView图像
        wm.addView(myFV, wmParams);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在程序退出(Activity销毁）时销毁悬浮窗口
        wm.removeView(myFV);
    }


}

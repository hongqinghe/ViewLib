package middlem.person.app;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.jaeger.library.StatusBarUtil;

import middlem.person.app.bar.ImmersionBar;
import person.middlem.viewmodule.statusBar.StatusBarCompat;

public class StatusTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
//        StatusKitkatBarImpl statusKitkatBar=new StatusKitkatBarImpl();
//        statusKitkatBar.setWindowStatusBar(this,getResources().getColor(R.color.common_red));
//        StatusBarCompat.setStatusBarColorTranslucent(this,getResources().getColor(R.color.white),true);
//        person.middlem.viewmodule.statusBar.StatusBarCompat.setStatusBarColorTranslucent(this,getResources().getColor(R.color.white));
//        StatusBarUtil.setColor(this,getResources().getColor(R.color.white));
        ImmersionBar.with(this).
                statusBarColor(R.color.white).statusBarColorTransformEnable(true).keyboardEnable(true) .init();
    }
}

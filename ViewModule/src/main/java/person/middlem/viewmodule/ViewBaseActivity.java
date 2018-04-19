package person.middlem.viewmodule;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class ViewBaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_base);

    }
}

package person.middlem.viewmodule.focus;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import person.middlem.viewmodule.R;

public class FocusActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_acitity);
        ChildFocusView view2 = findViewById(R.id.view2);
    }
}

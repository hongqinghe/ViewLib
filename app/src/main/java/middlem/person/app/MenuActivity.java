package middlem.person.app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.menu.popmenu.DropPopMenu;
import person.middlem.viewmodule.menu.popmenu.MenuItem;
import person.middlem.viewmodule.menu.tip.ToolTip;
import person.middlem.viewmodule.menu.tip.ToolTipsManager;

public class MenuActivity extends AppCompatActivity {

    private View menu;
    private ViewGroup group;
    DropPopMenu dropPopMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menu = findViewById(R.id.menu);
        group = findViewById(R.id.main);
    }

    public void showMenu(View view) {

        if(dropPopMenu == null){
            dropPopMenu = new DropPopMenu(MenuActivity.this);
        }
        dropPopMenu.setMenuList(getMenuList());

        dropPopMenu.show(view);
        dropPopMenu.setOnItemClickListener((adapterView, view1, position, id, menuItem) -> {
            if(position == 1){
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<MenuItem> getMenuList() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem(1, "选项"));
        list.add(new MenuItem(2, "选项选项选项"));
        return list;
    }

    public void showTips(View view) {
        ToolTipsManager mToolTipsManager = new ToolTipsManager();
        ToolTip.Builder builder = new ToolTip.Builder(this, menu, group, "aaa", ToolTip.POSITION_ABOVE);
        builder.setAlign(ToolTip.ALIGN_CENTER);
        builder.setBackgroundColor(Color.DKGRAY);
//        builder.setTextAppearance(R.style.TooltipTextAppearance);
        mToolTipsManager.show(builder.build());

//        if (mToolTipsManager.isVisible(menu)) {
//            mToolTipsManager.dismissAll();
//        }
    }
}

package person.middlem.viewmodule.uselayout;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import person.middlem.viewmodule.R;

/***********************************************
 *
 * <P> desc:   ConstrainLayout  use
 * <P> Author: gongtong
 * <P> Date: 2018-01-25 上午10:37
 ***********************************************/

public class ConstrainLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout);
        ShapeDrawable colorCode = new ShapeDrawable(new OvalShape()); colorCode.getPaint().setStyle(Paint.Style.FILL); //See more paint style for border circle etc. like STROKE colorCode.getPaint().setAntiAlias(true); colorCode.getPaint().setColor(getResources().getColor(YOUR_COLOUR_HERE_FROM_XML)); colorCode.setIntrinsicHeight(Globals.dp2px(5, getActivity())); //converting dp to px, you can just put any integer instead of dp2px method colorCode.setIntrinsicWidth(Globals.dp2px(5, getActivity())); greenText.setBackgroundDrawable(colorCode);

    }
}

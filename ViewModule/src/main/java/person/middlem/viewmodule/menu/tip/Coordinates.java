package person.middlem.viewmodule.menu.tip;

import android.view.View;

/***********************************************
 *
 * <P> desc:   
 * <P> Author: gongTong
 * <P> Date: 2019-01-17 16:30
 ***********************************************/
 
class Coordinates {

    int left;
    int top;
    int right;
    int bottom;

    Coordinates(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        left = location[0];
        right = left + view.getWidth();;
        top = location[1];
        bottom = top + view.getHeight();
    }


}

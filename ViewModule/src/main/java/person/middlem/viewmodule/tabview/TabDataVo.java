package person.middlem.viewmodule.tabview;

import android.support.annotation.Nullable;

/***********************************************
 * <P> desc:   tabView 数据集合 没有icon时设置为-1
 * <P> Author: gongtong
 * <P> Date: 2018/1/2 20:50
 ***********************************************/

public class TabDataVo {
    String tabText;
    int tabSelectIcon;

    int  tabUnSelectIcon;

    public TabDataVo(String tabText) {
        this.tabText = tabText;
        this.tabSelectIcon =-1;
        this.tabUnSelectIcon=-1;
    }

    public TabDataVo(String tabText, int tabSelectIcon,int tabUnSelectIcon) {
        this.tabText = tabText;
        this.tabSelectIcon = tabSelectIcon;
        this.tabUnSelectIcon=tabUnSelectIcon;
    }

    public int getTabUnSelectIcon() {
        return tabUnSelectIcon;
    }

    public void setTabUnSelectIcon(int tabUnSelectIcon) {
        this.tabUnSelectIcon = tabUnSelectIcon;
    }

    public String getTabText() {
        return tabText;
    }

    public void setTabText(String tabText) {
        this.tabText = tabText;
    }

    @Nullable
    public int getTabSelectIcon() {
        return tabSelectIcon;
    }

    public void setTabSelectIcon(int tabSelectIcon) {
        this.tabSelectIcon = tabSelectIcon;
    }
}

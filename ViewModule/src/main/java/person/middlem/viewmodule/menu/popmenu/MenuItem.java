package person.middlem.viewmodule.menu.popmenu;

/**
 *  Created by xiancai on 2018/12/25
 */
public class MenuItem {
    public int itemId;
    public String itemTitle;

    public MenuItem(int itemId, String itemTitle) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
    }
    public int getItemId() {
        return itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }
}

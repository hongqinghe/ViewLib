package person.middlem.viewmodule.listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import person.middlem.viewmodule.R;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2018/1/17 09:38
 ***********************************************/

public class ExpandAdapter implements ExpandableListAdapter {



    private List<String> titleList;
    private List<String> contentList;
    private Context mContext;

    public ExpandAdapter(List<String> titleList, List<String> contentList, Context context) {
        this.titleList=titleList;
        this.contentList=contentList;
        this.mContext=context;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {


    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return titleList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return contentList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return titleList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return contentList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TitleViewHolder titleViewHolder;
        if (convertView==null) {
            titleViewHolder=new TitleViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_expandable_group_view, null);
            titleViewHolder.title=convertView.findViewById(R.id.title);
            convertView.setTag(titleViewHolder);
        }else{
            titleViewHolder= (TitleViewHolder) convertView.getTag();
        }
        titleViewHolder.title.setText(titleList.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ContentViewHolder titleViewHolder;
        if (convertView==null) {
            titleViewHolder=new ContentViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_expandable_view, null);
            titleViewHolder.content=convertView.findViewById(R.id.content);
            convertView.setTag(titleViewHolder);
        }else{
            titleViewHolder= (ContentViewHolder) convertView.getTag();
        }
        titleViewHolder.content.setText(contentList.get(groupPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private class TitleViewHolder{
        TextView title;
    }
    private class ContentViewHolder{
        TextView content;
    }
}

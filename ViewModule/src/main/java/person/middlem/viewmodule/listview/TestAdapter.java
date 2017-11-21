package person.middlem.viewmodule.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.R;


public class TestAdapter extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<String> stringList;
     public TestAdapter(Context context, List<String> stringList) {
        this.mContext=context;
        this.stringList=stringList;
    }

    @Override
    public int getCount() {

        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         if (convertView==null) {
             convertView = LayoutInflater.from(mContext).inflate(R.layout.item_view, null);
         }
         TextView view = ViewHolderUtils.get(convertView, R.id.content);
        view.setText(stringList.get(position));

        return convertView;
    }

    @Override
    public Filter getFilter() {
         MyFilter myFilter=new MyFilter();
        return myFilter;
    }
    private List<String > filterList;

     private Object mLock=new Object();
    class MyFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (filterList == null) {
                synchronized (mLock) {
                    filterList = new ArrayList<String>(stringList);
                }
            }
            if (prefix == null || prefix.length() == 0) {
                synchronized (mLock) {
                    ArrayList<String> list = new ArrayList<String>(
                            filterList);
                    results.values = list;
                    results.count = list.size();
                }
            } else {
                String prefixString = prefix.toString().toLowerCase();

                final ArrayList<String> values = (ArrayList<String>) stringList;

                final int count = values.size();

                final ArrayList<String> newValues = new ArrayList<String>(
                        count);

                for (String value : values) {
                    String title = value.toLowerCase();

                    if (title.indexOf(prefixString) != -1) {
                        newValues.add(value);
                    }
                }

                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            stringList = (ArrayList<String>) results.values;

            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

    }

}
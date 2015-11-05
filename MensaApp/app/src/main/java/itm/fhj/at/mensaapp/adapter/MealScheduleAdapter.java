package itm.fhj.at.mensaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeSet;

import itm.fhj.at.mensaapp.R;

/**
 * Created by michael.stifter on 04.11.2015.
 */
public class MealScheduleAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    private ArrayList<String> mData = new ArrayList<String>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

    private LayoutInflater mInflater;

    public MealScheduleAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final String item) {
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_HEADER : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();

            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.item_meal_schedule_day_meal, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.text_day);
                    break;

                case TYPE_HEADER:
                    convertView = mInflater.inflate(R.layout.item_meal_schedule_day_meal, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.text_meal);
                    break;
            }

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(mData.get(position));

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }
}

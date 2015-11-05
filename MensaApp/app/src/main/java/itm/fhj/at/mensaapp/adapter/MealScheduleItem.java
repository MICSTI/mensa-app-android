package itm.fhj.at.mensaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;

import itm.fhj.at.mensaapp.R;

/**
 * Created by michael.stifter on 05.11.2015.
 */
public class MealScheduleItem implements Item {

    private static int type = MealScheduleAdapter.TYPE_ITEM;

    public MealScheduleItem() {

    }

    @Override
    public int getViewType() {
        return type;
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;

        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.item_meal_schedule_day_meal, null);
        } else {
            view = convertView;
        }

        return view;
    }
}

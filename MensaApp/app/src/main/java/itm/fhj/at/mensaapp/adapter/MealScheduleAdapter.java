package itm.fhj.at.mensaapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import itm.fhj.at.mensaapp.R;
import itm.fhj.at.mensaapp.model.MealSchedule;

/**
 * Created by michael.stifter on 04.11.2015.
 */
public class MealScheduleAdapter extends ArrayAdapter<MealSchedule> {
    public MealScheduleAdapter(Context context, List<MealSchedule> mealScheduleList) {
        super(context, R.layout.item_meal_schedule, mealScheduleList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the item for this position
        MealSchedule mealSchedule = getItem(position);

        // return the completed view to render on screen
        return convertView;
    }
}

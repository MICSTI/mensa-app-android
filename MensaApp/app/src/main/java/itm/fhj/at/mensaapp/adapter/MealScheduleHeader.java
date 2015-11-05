package itm.fhj.at.mensaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import itm.fhj.at.mensaapp.R;

/**
 * Created by michael.stifter on 05.11.2015.
 */
public class MealScheduleHeader implements Item {

    private static int type = MealScheduleAdapter.TYPE_HEADER;

    private String text;

    public MealScheduleHeader(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public int getViewType() {
        return type;
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;

        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.item_meal_schedule_day_head, null);
        } else {
            view = convertView;
        }

        TextView txtDay = (TextView) view.findViewById(R.id.text_day);
        txtDay.setText(this.text);

        return view;
    }
}

package itm.fhj.at.mensaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by michael.stifter on 05.11.2015.
 */
public interface Item {
    public int getViewType();
    public View getView(LayoutInflater inflater, View convertView);
}

package itm.fhj.at.mensaapp.activity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import itm.fhj.at.mensaapp.R;
import itm.fhj.at.mensaapp.handler.HTMLDataHandler;
import itm.fhj.at.mensaapp.model.Location;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationsList extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ArrayList<String> retrievedLocations = (ArrayList<String>)getIntent().getSerializableExtra("LOCATIONS");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, retrievedLocations);

        setListAdapter(adapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // Check if value not 0
        // Store selected value
    }
}
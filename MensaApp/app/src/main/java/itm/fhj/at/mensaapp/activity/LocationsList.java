package itm.fhj.at.mensaapp.activity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LocationsList extends ListActivity {

    private ArrayList<String> retrievedLocations = new ArrayList<String>();

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.retrievedLocations = (ArrayList<String>)getIntent().getSerializableExtra("LOCATIONS");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.retrievedLocations);

        setListAdapter(adapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Location selectedLocation = (Location) getListAdapter().getItem(position);

        if(selectedLocation.getId() > 0){
            int mensaId = selectedLocation.getId();

            // store selected mensa in shared preferences
            SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("selectedMensaId", mensaId);
            editor.commit();

            // start mensa detail activity
            Intent i = new Intent(LocationsList.this, MensaDetail.class);
            i.putExtra("MENSA_ID", mensaId);
            startActivity(i);
        } else{
            Toast toast = Toast.makeText(this, "Sie können keine Kategorie auswählen!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
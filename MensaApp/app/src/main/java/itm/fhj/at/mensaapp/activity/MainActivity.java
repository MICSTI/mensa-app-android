package itm.fhj.at.mensaapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.jsoup.nodes.Document;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import itm.fhj.at.mensaapp.R;
import itm.fhj.at.mensaapp.handler.AsyncLoader;
import itm.fhj.at.mensaapp.handler.HTMLDataHandler;
import itm.fhj.at.mensaapp.handler.LocationsHandler;
import itm.fhj.at.mensaapp.interfaces.ICallback;
import itm.fhj.at.mensaapp.interfaces.IParseCallback;
import itm.fhj.at.mensaapp.model.Location;


public class MainActivity extends Activity implements IParseCallback{

    private ArrayList<Location> retrievedLocations = new ArrayList<Location>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load locations
        HTMLDataHandler dataHandler = new HTMLDataHandler();
        dataHandler.setCallback(this);
        dataHandler.loadHTMLStringFromURL("http://www.mensen.at");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent i = new Intent(MainActivity.this, LocationsList.class);
            i.putExtra("LOCATIONS", this.retrievedLocations);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void processLocationData(Document locationData) {
        LocationsHandler locationsHandler = new LocationsHandler(locationData);
        this.retrievedLocations = locationsHandler.getLocations();

        // Check here if location is selected (true = do nothing; false = show the list activity)
        Intent i = new Intent(MainActivity.this, LocationsList.class);
        i.putExtra("LOCATIONS", this.retrievedLocations);
        startActivity(i);
    }
}

package itm.fhj.at.mensaapp.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Locale;

import itm.fhj.at.mensaapp.R;
import itm.fhj.at.mensaapp.handler.AsyncLoader;
import itm.fhj.at.mensaapp.handler.HTMLDataHandler;
import itm.fhj.at.mensaapp.handler.LocationsHandler;
import itm.fhj.at.mensaapp.interfaces.ICallback;
import itm.fhj.at.mensaapp.interfaces.IParseCallback;
import itm.fhj.at.mensaapp.model.Location;


public class MainActivity extends Activity implements IParseCallback {

    MensaDetailFragment mensaDetailFragment;

    private ArrayList<Location> retrievedLocations = new ArrayList<Location>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentParentViewGroup, new PlaceholderFragment())
                    .commit();
        }

        // Load locations
        /*HTMLDataHandler dataHandler = new HTMLDataHandler();
        dataHandler.setCallback(this);
        dataHandler.loadHTMLStringFromURL("http://www.mensen.at");*/
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

        // TODO Check here if location is selected (true = do nothing; false = show the list activity)
        Intent i = new Intent(MainActivity.this, LocationsList.class);
        i.putExtra("LOCATIONS", this.retrievedLocations);
        startActivity(i);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            return rootView;
        }
    }
}